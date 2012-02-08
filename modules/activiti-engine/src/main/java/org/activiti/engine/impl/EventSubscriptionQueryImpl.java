/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.engine.impl;

import java.io.Serializable;
import java.util.List;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.interceptor.CommandExecutor;
import org.activiti.engine.runtime.EventSubscription;
import org.activiti.engine.runtime.EventSubscriptionQuery;


/**
 * @author Daniel Meyer
 */
public class EventSubscriptionQueryImpl 
                extends AbstractQuery<EventSubscriptionQuery, EventSubscription> 
                implements EventSubscriptionQuery, Serializable {

  private static final long serialVersionUID = 1L;
  
  protected String eventSubscriptionId;
  protected String eventName;
  protected String eventType;
  protected String executionId;
  protected String processInstanceId;
  protected String activityId;
  protected String eventScope;

  public EventSubscriptionQueryImpl(CommandContext commandContext) {
    super(commandContext);
  }
  
  public EventSubscriptionQueryImpl(CommandExecutor commandExecutor) {
    super(commandExecutor);
  }

  public EventSubscriptionQuery eventSubscriptionId(String id) {
    if (eventSubscriptionId == null) {
      throw new ActivitiException("Provided svent subscription id is null");
    }
    this.eventSubscriptionId = id;
    return this;
  }

  public EventSubscriptionQuery eventName(String eventName) {
    if (eventName == null) {
      throw new ActivitiException("Provided event name is null");
    }
    this.eventName = eventName;
    return this;
  }

  public EventSubscriptionQuery executionId(String executionId) {
    if (executionId == null) {
      throw new ActivitiException("Provided execution id is null");
    }
    this.executionId = executionId;
    return this;
  }

  public EventSubscriptionQuery processInstanceId(String processInstanceId) {
    if (processInstanceId == null) {
      throw new ActivitiException("Provided process instance id is null");
    }
    this.processInstanceId = processInstanceId;
    return this;
  }

  public EventSubscriptionQuery activityId(String activityId) {
    if (activityId == null) {
      throw new ActivitiException("Provided activity id is null");
    }
    this.activityId = activityId;
    return this;
  }
  
  public EventSubscriptionQuery eventType(String eventType) {
    if (eventType == null) {
      throw new ActivitiException("Provided event type is null");
    }
    this.eventType = eventType;
    return this;
  }
  
  public EventSubscriptionQuery eventScope(String eventScope) {
    if (eventScope == null) {
      throw new ActivitiException("Provided event scope is null");
    }
    this.eventScope = eventScope;
    return this;
  }
  
  public EventSubscriptionQuery orderByCreated() {
    return this;    
  }
  
  //results //////////////////////////////////////////

  @Override
  public long executeCount(CommandContext commandContext) {
    checkQueryOk();
    return commandContext
      .getEventSubscriptionManager()
      .findEventSubscriptionCountByQueryCriteria(this);
  }

  @Override
  public List<EventSubscription> executeList(CommandContext commandContext, Page page) {
    checkQueryOk();
    return commandContext
      .getEventSubscriptionManager()
      .findEventSubscriptionsByQueryCriteria(this,page);
  }
  
  //getters //////////////////////////////////////////
  
   
  public String getEventSubscriptionId() {
    return eventSubscriptionId;
  }
  public String getEventName() {
    return eventName;
  }
  public String getEventType() {
    return eventType;
  }
  public String getExecutionId() {
    return executionId;
  }
  public String getProcessInstanceId() {
    return processInstanceId;
  }
  public String getActivityId() {
    return activityId;
  }
  public String getEventScope() {
    return eventScope;
  }

}