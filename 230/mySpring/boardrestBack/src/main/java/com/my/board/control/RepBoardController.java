package com.my.board.control;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.my.board.service.RepBoardService;
import com.my.board.vo.RepBoard;
import com.my.customer.vo.Customer;
import com.my.dto.PageDTO;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.ModifyException;
import com.my.exception.RemoveException;
//@Controller

import net.coobird.thumbnailator.Thumbnailator;
@RestController
@RequestMapping("board/*")
public class RepBoardController {
	@Autowired
	private RepBoardService service;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@PostMapping("/write")
	public ResponseEntity<?> write(
			 @RequestPart(required = false) List<MultipartFile> letterFiles
			,@RequestPart(required = false) MultipartFile imageFile
			,RepBoard repBoard
			,String greeting
			,HttpSession session){

		logger.info("요청전달데이터 title=" + repBoard.getBoardTitle() + ", content=" + repBoard.getBoardContent());
		logger.info("letterFiles.size()=" + letterFiles.size());
		logger.info("imageFile.getSize()=" + imageFile.getSize() + ", imageFile.getOriginalFileName()=" + imageFile.getOriginalFilename());
		logger.info(greeting);
		 
		//게시글내용 DB에 저장
		try {
			Customer c = (Customer)session.getAttribute("loginInfo");
			//---로그인대신할 샘플데이터--
			//Customer c = new Customer();
			//c.setId("id1");
			//----------------------
			repBoard.setBoardC(c);
			service.write(repBoard);
		} catch (AddException e1) {
			e1.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		//파일 경로 생성
		String saveDirectory = "c:\\files";
		if ( ! new File(saveDirectory).exists()) {
			logger.info("업로드 실제경로생성");
			new File(saveDirectory).mkdirs();
		}
		
		int wroteBoardNo = repBoard.getBoardNo();//저장된 글의 글번호
		
		File thumbnailFile = null;
		long imageFileSize = imageFile.getSize();
		if(imageFileSize > 0) {
			//이미지파일 저장하기
			String imageOrignFileName = imageFile.getOriginalFilename(); //이미지파일원본이름얻기
			logger.info("이미지 파일이름:" + imageOrignFileName +", 파일크기: " + imageFile.getSize());
			
			//저장할 파일이름을 지정한다 ex) 글번호_image_XXXX_원본이름
			String imageFileName = wroteBoardNo + "_image_" + UUID.randomUUID() + "_" + imageOrignFileName;
			//이미지파일생성
			File savedImageFile = new File(saveDirectory, imageFileName);
			
			
			try {
				FileCopyUtils.copy(imageFile.getBytes(), savedImageFile);
				logger.info("이미지 파일저장:" + savedImageFile.getAbsolutePath());
				
				//파일형식 확인
				String contentType = imageFile.getContentType();
				if(!contentType.contains("image/")) { //이미지파일형식이 아닌 경우
					return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
				}
				
				//이미지파일인 경우 섬네일파일을 만듦
				String thumbnailName =  "s_"+imageFileName; //섬네일 파일명은 s_글번호_XXXX_원본이름
				thumbnailFile = new File(saveDirectory,thumbnailName);
				FileOutputStream thumbnailOS;
				thumbnailOS = new FileOutputStream(thumbnailFile);
				InputStream imageFileIS = imageFile.getInputStream();
				int width = 100;
				int height = 100;
				Thumbnailator.createThumbnail(imageFileIS, thumbnailOS, width, height);
				logger.info("섬네일파일 저장:" + thumbnailFile.getAbsolutePath() + ", 섬네일파일 크기:" + thumbnailFile.length());
	
			} catch (IOException e2) {
				e2.printStackTrace();
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}//end if(imageFileSize > 0) 
		
		
		//letterFiles도 저장
		if(letterFiles != null) {
			for(MultipartFile letterFile: letterFiles) {
				long letterFileSize = letterFile.getSize();
				if(letterFileSize > 0) {
					String letterOriginFileName = letterFile.getOriginalFilename(); //자소서 파일원본이름얻기
					//지원서 파일들 저장하기
					logger.info("지원서 파일이름: " + letterOriginFileName +" 파일크기: " + letterFile.getSize());
					//저장할 파일이름을 지정한다 ex) 글번호_letter_XXXX_원본이름
					String letterfileName = wroteBoardNo + "_letter_" + UUID.randomUUID() + "_" + letterOriginFileName;
					File savevdLetterFile = new File(saveDirectory, letterfileName);//파일생성
					try {
						FileCopyUtils.copy(letterFile.getBytes(), savevdLetterFile);
						logger.info("지원서 파일저장:" + savevdLetterFile.getAbsolutePath());
					} catch (IOException e) {
						e.printStackTrace();
						return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}//end if(letterFileSize > 0)
			}
		}//end if(letterFiles != null) 
		
		
		if(thumbnailFile == null) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		try {
			//이미지 썸네일다운로드하기
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.set(HttpHeaders.CONTENT_LENGTH, thumbnailFile.length()+"");
	    	responseHeaders.set(HttpHeaders.CONTENT_TYPE, Files.probeContentType(thumbnailFile.toPath()));
		   	responseHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename="+URLEncoder.encode("a", "UTF-8"));
			logger.info("섬네일파일 다운로드");
	    	return new ResponseEntity<>(FileCopyUtils.copyToByteArray(thumbnailFile), responseHeaders, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 
	@GetMapping(value= {"/list", "/list/{currentPage}"})
	public Object  list(@PathVariable Optional<Integer> currentPage) {
		try {
			PageDTO<RepBoard> pageDTO;
			if(currentPage.isPresent()) { //currentPage값이 있는 경우
				int cp = currentPage.get();
				pageDTO = service.findAll(cp);
			}else { //값이 없는 경우(null인 경우)
				pageDTO = service.findAll();
			}
			
			return pageDTO;
		}catch(FindException e) {
			Map<String, Object> returnMap = new HashMap<>();
			returnMap.put("msg", e.getMessage());
			returnMap.put("status", 0);
			return returnMap;
		}
	}
	@GetMapping(value= {"/search", "/search/{word}", "/search/{word}/{currentPage}"})
	public Object  search(@PathVariable Optional<String>  word, 
			              @PathVariable Optional<Integer> currentPage) {
		try {
			PageDTO<RepBoard> pageDTO;
			String w = "";
			if(word.isPresent()) {
				w = word.get();
			}else {
				return list(currentPage);
			}
			int cp = 1;
			if(currentPage.isPresent()) { //currentPage값이 있는 경우
				cp = currentPage.get();			
			}
			pageDTO = service.findByWord(w, cp);
			return pageDTO;			
		}catch(FindException e) {
			Map<String, Object> returnMap = new HashMap<>();
			returnMap.put("msg", e.getMessage());
			returnMap.put("status", 0);
			return returnMap;
		}
	}

	@GetMapping("/{boardNo}")
//	@ResponseBody
	public Object info(@PathVariable(name = "boardNo")  int no) {
		try {
			
			RepBoard rb = service.findByNo(no);
//			return rb;
			Map<String, Object> returnMap  = new HashMap<>();
			returnMap.put("repBoard", rb);
			String saveDirectory = "c:\\files";
			File dir = new File(saveDirectory);
			
			String[] letterFileNames = dir.list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.contains(no+"_letter_");
				}
			});
			if(letterFileNames.length > 0 ) {
				returnMap.put("letters", letterFileNames);
			}
			
			String[] imageFiles = dir.list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					return name.contains("s_"+ no+"_image_");
				}
			}); 
			
			if(imageFiles.length > 0 ) {
				returnMap.put("image", imageFiles[0]);
			}
			return returnMap;
		} catch (FindException e) {
			e.printStackTrace();
			Map<String, Object> returnMap  = new HashMap<>();
			returnMap.put("msg", e.getMessage());
			returnMap.put("status", 0);
			return returnMap;
		}
	}
	
	@PostMapping("/reply")
	//public Object reply(RepBoard repBoard) {
	public Object reply(@RequestBody RepBoard repBoard, HttpSession session) {
		logger.error(repBoard.getBoardTitle() + ", " + repBoard.getBoardContent());
		Map<String, Object> returnMap = new HashMap<>();
		Customer c = (Customer)session.getAttribute("loginInfo");
		//---로그인대신할 샘플데이터--
//		Customer c = new Customer();
//		c.setId("id1");
		//----------------------
		repBoard.setBoardC(c);
		if(c == null) {
			returnMap.put("status", 0);
			returnMap.put("msg", "로그인되지 않아서 수정할 수 없습니다");
			return returnMap;
		}
		try {
			logger.info(repBoard.getBoardTitle());
			service.reply(repBoard);
			returnMap.put("status", 1);
		} catch (AddException e) {
			e.printStackTrace();
			returnMap.put("status", 0);
			returnMap.put("msg", e.getMessage());
		}
		return returnMap;
	}
	
	@PutMapping("/{boardNo}")
	public Object modify(@PathVariable int boardNo, 
			             @RequestBody RepBoard repBoard, 
			             HttpSession session) {
		Map<String, Object> returnMap = new HashMap<>();
		
		Customer c = (Customer)session.getAttribute("loginInfo");
		//---로그인대신할 샘플데이터--
//		Customer c = new Customer();
//		c.setId("id1");
		//----------------------
		if(c == null) {
			returnMap.put("status", 0);
			returnMap.put("msg", "로그인되지 않아서 수정할 수 없습니다");
			return returnMap;
		}
		try {
			//repBoard.setBoardNo(boardNo);
			repBoard.setBoardC(c);
			logger.error("repBoard.getBoardContent()=" + repBoard.getBoardContent());
			
			service.modify(repBoard);
			returnMap.put("status", 1);
		}catch(ModifyException e) {
			returnMap.put("status", 0);
			returnMap.put("msg", e.getMessage());
			
		}
		return returnMap;
	}
	
	@DeleteMapping("/{boardNo}")
	public Object remove(@PathVariable int boardNo, HttpSession session) {
		Map<String, Object> returnMap = new HashMap<>();
		
		Customer c = (Customer)session.getAttribute("loginInfo");
		//---로그인대신할 샘플데이터--
//		Customer c = new Customer();
//		c.setId("id1");
		//----------------------
		if(c == null) {
			returnMap.put("status", 0);
			returnMap.put("msg", "로그인되지 않아서 수정할 수 없습니다");
			return returnMap;
		}
		try {
			RepBoard repBoard = new RepBoard();
			repBoard.setBoardNo(boardNo);
			repBoard.setBoardC(c);
			service.remove(repBoard);
			returnMap.put("status", 1);
		}catch(RemoveException e) {
			returnMap.put("status", 0);
			returnMap.put("msg", e.getMessage());
			
		}
		return returnMap;
	}
	
	@GetMapping("board/download")
	public ResponseEntity<Resource>  download(String fileName) throws UnsupportedEncodingException {
		logger.info("첨부파일 다운로드");
		//파일 경로생성
		String saveDirectory = "c:\\files";
		
		//HttpHeaders : 요청/응답헤더용 API
		HttpHeaders headers = new HttpHeaders();	
		headers.add(HttpHeaders.CONTENT_TYPE, "application/octet-stream;charset=UTF-8");
		//다운로드시 파일이름 결정
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
		
		//Resource : 자원(파일, URL)용 API
		//다운로드할 파일의 실제 경로 얻기
		File f = new File(saveDirectory, fileName);		
		Resource resource = new FileSystemResource(f);
		try {
			logger.info("첨부파일이름: " + resource.getFilename());
			logger.info("첨부파일resource.contentLength()=" + resource.contentLength());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResponseEntity<Resource> responseEntity  =  
				new ResponseEntity<>(resource, headers, HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("board/downloadimage")
	public ResponseEntity<?>  downloadImage(String imageFileName) {
		String saveDirectory = "c:\\files";
		File thumbnailFile = new File(saveDirectory, imageFileName);
		HttpHeaders responseHeaders = new HttpHeaders();
		try {
			responseHeaders.set(HttpHeaders.CONTENT_LENGTH, thumbnailFile.length()+"");
	    	responseHeaders.set(HttpHeaders.CONTENT_TYPE, Files.probeContentType(thumbnailFile.toPath()));
		   	responseHeaders.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename="+URLEncoder.encode("a", "UTF-8"));
			logger.info("섬네일파일 다운로드");
	    	return new ResponseEntity<>(FileCopyUtils.copyToByteArray(thumbnailFile), responseHeaders, HttpStatus.OK);
		}catch(IOException e) {
			return new ResponseEntity<>("이미지파일 다운로드 실패" , HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
