package br.com.am.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.assistant.v1.model.Context;
import com.ibm.watson.assistant.v1.model.MessageInput;
import com.ibm.watson.assistant.v1.model.MessageOptions;
import com.ibm.watson.assistant.v1.model.MessageResponse;
import com.ibm.watson.assistant.v1.Assistant;

@WebServlet(urlPatterns = "/v1")
public class AssistantV1Servlet extends HttpServlet {
	
	private Context context;
	private static final long serialVersionUID = -8716683257301345455L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		String msg = req.getParameter("question");
		if (msg.isEmpty()) this.context = null;
		
		MessageResponse response = this.assistantAPICall(msg);
		
		resp.setContentType("application/json");
		resp.getWriter().write(new Gson().toJson(response.getOutput().getText()));
	}

	private MessageResponse assistantAPICall(String msg) {

		
		IamOptions options = new IamOptions.Builder()
				.apiKey("Zfq-xWeBOS5zkYvfFVdCTbxra63EQIP6BpropO9ydZDR")
				.build();
		
		
		Assistant service = new Assistant("2018-02-16", options);
		String workspaceId = "51cc9a53-49d6-4dd9-9341-43682422eed0";
		
	
		MessageInput input = new MessageInput();
		input.setText(msg);
		MessageOptions messageOptions = new MessageOptions.Builder()
				.workspaceId(workspaceId)
				.input(input)
				.context(this.context)
				.build();
		
		MessageResponse response  = service.message(messageOptions)
				.execute()
				.getResult();
		
		this.context = response.getContext();
	
		if (response.getContext().getSystem().getProperties().get("branch_exited") != null)
			if ((boolean) response.getContext().getSystem().getProperties().get("branch_exited") &&
					response.getContext().getSystem().getProperties().get("branch_exited_reason").equals("completed"))
				this.context = null;
		
		return response;
	}

}
