<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@ include file="header.jsp" %>

              
              
<br>
<h2 align="center">Shipping Address</h2>
<br>

<div class="container">
<form:form method="POST" modelAttribute="shippingAddress">
  
                     
        <div class="form-group row">
        <form:label path="streetAddress" class="col-sm-2 col-form-label">Street Address</form:label>
                      <div class="col-sm-10">
        <form:input path="streetAddress" class="form-control" placeholder="street address"/>
        <form:errors path="streetAddress" class="form-control" cssClass="error" ></form:errors>
     </div>
              </div> 
              
        
         <div class="form-group row">
        <form:label path="city" class="col-sm-2 col-form-label">City</form:label>
                      <div class="col-sm-10">
        <form:input path="city" class="form-control" placeholder="city name"/>
        <form:errors path="city" class="form-control" cssClass="error" ></form:errors>
     </div>
              </div> 
              
              
          <div class="form-group row">
        <form:label path="state" class="col-sm-2 col-form-label">State</form:label>
                      <div class="col-sm-10">
        <form:input path="state" class="form-control" placeholder="state name"/>
        <form:errors path="state" class="form-control" cssClass="error" ></form:errors>
     </div>
              </div> 
              
         
          <div class="form-group row">
        <form:label path="postalCode" class="col-sm-2 col-form-label">PostalCode</form:label>
                      <div class="col-sm-10">
        <form:input path="postalCode" class="form-control" placeholder="postalCode"/>
        <form:errors path="postalCode" class="form-control" cssClass="error" ></form:errors>
     </div>
              </div> 
              
                <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
                  <input name="_eventId_submit" type="submit" value="AddDetails" class="btn btn-primary"/>
      
      </div>
    </div>       

         
</form:form>
</div>
 
   
<%@include file="footer.jsp" %>