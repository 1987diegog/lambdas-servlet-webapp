package uy.com.demente.ideas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/lambda")
public class LamndaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final static String PARAM_ID = "paramId";
	private final static String PARAM_NAME = "paramName";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		CacheHelper cacheHelper = CacheHelper.getSingletonCacheHelper();

		String json = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		JSONObject obj = new JSONObject(json);
		String paramId = obj.getString(PARAM_ID);
		String paramName = obj.getString(PARAM_NAME);

		Integer id = Integer.parseInt(paramId);

		System.out.println("Param id: " + id);
		System.out.println("Param name: " + paramName);

		cacheHelper.add(id, paramName);
	}

	/**
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CacheHelper cacheHelper = CacheHelper.getSingletonCacheHelper();

		String paramId = request.getParameter(PARAM_ID);
		Integer id = Integer.parseInt(paramId);

		System.out.println("Param id: " + id);
		String data = cacheHelper.get(id);

		PrintWriter pw = response.getWriter();

		pw.println("<html>");
		pw.println("<body>");
		pw.println(data);
		pw.println("</body>");
		pw.println("</html>");
	}
}
