package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;
import com.google.gson.*;

public class ChartController extends HttpServlet {
      
    public ChartController() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductModel productModel = new ProductModel(); 
		Gson gson = new Gson();
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.println(gson.toJson(productModel.findAll()));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
