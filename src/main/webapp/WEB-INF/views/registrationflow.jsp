<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@ include file="header.jsp" %>

<br>
<h2 align="center">Personal Details</h2>
<br>

 <div class="container">
 <form:form method="POST" modelAttribute="userDetails">
  
    
        <div class="form-group row">
        <form:label type="hidden" path="userId" class="col-sm-2 col-form-label"></form:label>
              <div class="col-sm-10">
        <form:input type="hidden" path="userId" class="form-control"/>
        </div>
    </div>
        
   
    <div class="form-group row">
        <form:label path="userName" class="col-sm-2 col-form-label">User Name</form:label>
              <div class="col-sm-10">
        <form:input path="userName" class="form-control" placeholder="User Name"/>
        <form:errors path="userName"  class="form-control" cssClass="error" ></form:errors>
              </div>
              </div>
        
          
        <div class="form-group row">
        <form:label path="password" class="col-sm-2 col-form-label">Password</form:label>
                      <div class="col-sm-10">
        <form:input type="password" path="password" class="form-control" placeholder="password"/>
        <form:errors path="password" class="form-control" cssClass="error" ></form:errors>
     </div>
              </div>
        
    
        <div class="form-group row">
        <form:label path="fname" class="col-sm-2 col-form-label">First Name</form:label>
                      <div class="col-sm-10">
        <form:input path="fname" class="form-control" placeholder="first name"/>
        <form:errors path="fname" class="form-control" cssClass="error" ></form:errors>
     </div>
              </div>
              
              
        <div class="form-group row">
        <form:label path="lname" class="col-sm-2 col-form-label">Last Name</form:label>
                      <div class="col-sm-10">
        <form:input path="lname" class="form-control" placeholder="last name"/>
        <form:errors path="lname" class="form-control" cssClass="error" ></form:errors>
     </div>
              </div>     
        
        
        <div class="form-group row">
        <form:label path="contact" class="col-sm-2 col-form-label">Contact Number</form:label>
                      <div class="col-sm-10">
        <form:input path="contact" class="form-control" placeholder="contact number"/>
        <form:errors path="contact" class="form-control" cssClass="error" ></form:errors>
     </div>
              </div>
              
         
        <div class="form-group row">
        <form:label path="email" class="col-sm-2 col-form-label">Email</form:label>
                      <div class="col-sm-10">
        <form:input path="email" type="email" class="form-control" placeholder="email address"/>
        <form:errors path="email" class="form-control" cssClass="error" ></form:errors>
     </div>
              </div>  
              
              <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
                  <input name="_eventId_submit" type="submit" value="AddDetails" class="btn btn-primary"/>
      
      </div>
    </div>
    
              </form:form>
              </div>
              
 <%@ include file="footer.jsp" %>
              