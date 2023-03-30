package ex11_upload_download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/DownloadServlet")

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DownloadServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 파라미터
		request.setCharacterEncoding("UTF-8");
		
		String path = URLDecoder.decode(request.getParameter("path"), "UTF-8");
		
		// 다운로드 해야 할 File 객체
		File file = new File(path);	// path에 경로와 파일명 모두 들어있기 때문에 작성 가능
		
		// 다운로드 해야 할 파일을 읽어들일 입력 스트림 (BufferedInputStream)
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
		
		// 다운로드용 응답 헤더 작업
		response.setHeader("Content-Disposition", "attachment");	// 다운로드 경로와 파일명 직접 입력
		response.setHeader("Content-Length", file.length() + "");
		
		// 응답 스트림 (출력 스트림)
		BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
		
		// 파일 복사 (in에서 1024바이트를 읽은 다음 out으로 보내기)
		byte[] b = new byte[1024];		// 입력 단위
		int readByte = 0;				// 실제로 읽은 바이트
		while((readByte = in.read(b)) != -1) {	// read메소드는 읽을게 없으면 -1을 반환한다.
			out.write(b, 0, readByte);			// b 배열의 인덱스 0부터 readByte만큼 출력한다.
		}
		out.close();
		in.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}