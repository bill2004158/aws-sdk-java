/*
 * Copyright 2010-2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.simpleworkflow.model.transform;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.List;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.simpleworkflow.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * Get Workflow Execution History Request Marshaller
 */
public class GetWorkflowExecutionHistoryRequestMarshaller implements Marshaller<Request<GetWorkflowExecutionHistoryRequest>, GetWorkflowExecutionHistoryRequest> {

    

    public Request<GetWorkflowExecutionHistoryRequest> marshall(GetWorkflowExecutionHistoryRequest getWorkflowExecutionHistoryRequest) {
		if (getWorkflowExecutionHistoryRequest == null) {
		    throw new AmazonClientException("Invalid argument passed to marshall(...)");
		}

        Request<GetWorkflowExecutionHistoryRequest> request = new DefaultRequest<GetWorkflowExecutionHistoryRequest>(getWorkflowExecutionHistoryRequest, "AmazonSimpleWorkflow");
        String target = "SimpleWorkflowService.GetWorkflowExecutionHistory";
        request.addHeader("X-Amz-Target", target);
        request.addHeader("Content-Type", "application/x-amz-json-1.0");

        
        request.setHttpMethod(HttpMethodName.POST);


        String uriResourcePath = ""; 

        if (uriResourcePath.contains("?")) {
            String queryString = uriResourcePath.substring(uriResourcePath.indexOf("?") + 1);
            uriResourcePath    = uriResourcePath.substring(0, uriResourcePath.indexOf("?"));

            for (String s : queryString.split("[;&]")) {
                String[] nameValuePair = s.split("=");
                if (nameValuePair.length == 2) {
                    request.addParameter(nameValuePair[0], nameValuePair[1]);
                } else {
                    request.addParameter(s, null);
                }
            }
        }

        request.setResourcePath(uriResourcePath);


        
        try {
        	StringWriter stringWriter = new StringWriter();
        	JSONWriter jsonWriter = new JSONWriter(stringWriter);

        	
            
        	jsonWriter.object();
        	
            if (getWorkflowExecutionHistoryRequest.getDomain() != null) {
                jsonWriter.key("domain").value(getWorkflowExecutionHistoryRequest.getDomain());
            }
            WorkflowExecution execution = getWorkflowExecutionHistoryRequest.getExecution();
            if (execution != null) {

                jsonWriter.key("execution");
                jsonWriter.object();

                if (execution.getWorkflowId() != null) {
                    jsonWriter.key("workflowId").value(execution.getWorkflowId());
                }
                if (execution.getRunId() != null) {
                    jsonWriter.key("runId").value(execution.getRunId());
                }
                jsonWriter.endObject();
            }
            if (getWorkflowExecutionHistoryRequest.getNextPageToken() != null) {
                jsonWriter.key("nextPageToken").value(getWorkflowExecutionHistoryRequest.getNextPageToken());
            }
            if (getWorkflowExecutionHistoryRequest.getMaximumPageSize() != null) {
                jsonWriter.key("maximumPageSize").value(getWorkflowExecutionHistoryRequest.getMaximumPageSize());
            }
            if (getWorkflowExecutionHistoryRequest.isReverseOrder() != null) {
                jsonWriter.key("reverseOrder").value(getWorkflowExecutionHistoryRequest.isReverseOrder());
            }

    	    jsonWriter.endObject();
        	

    	    String snippet = stringWriter.toString();
    	    byte[] content = snippet.getBytes("UTF-8");
        	request.setContent(new StringInputStream(snippet));
	        request.addHeader("Content-Length", Integer.toString(content.length));
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }
        

        return request;
    }

    private String getString(String s) {
        if (s == null) return "";
        return s;
    }
}