package org.example.demo;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import java.time.LocalDateTime;
import java.util.*;
import org.json.JSONObject;

/**
 * Azure Functions with Event Hub trigger.
 */
public class EventHubTriggerFunction {

  /**
   * This function will be invoked when an event is received from Event Hub.
   */
  @FunctionName("EventHubTrigger-Java")

  //eventHubName對應azure eventhub名稱，connection對應local.setting.json內azure eventhub connection-string的名稱
  public void run(
      @EventHubTrigger(name = "message", eventHubName = "eventhubexample", connection = "myconnvarname", dataType = "string") List<String> message,
      final ExecutionContext context) {
    context.getLogger().info("Java Event Hub trigger function executed.");
    context.getLogger().info("Length:" + message.size());
    message.forEach(singleMessage -> context.getLogger().info(singleMessage));
  }


//  @FunctionName("outputjson")
//  public void outputJson(
//      @EventHubTrigger(name = "message", eventHubName = "eventhubexample", connection = "myconnvarname", dataType = "string") List<String> message,
//      final ExecutionContext context) {
//    context.getLogger().info("Java Event Hub trigger function executed.");
//    context.getLogger().info("Length:" + message.size());
//
//    message.forEach(singleMessage -> context.getLogger().info(
//        String.valueOf(new JSONObject(singleMessage))));
//  }



}
