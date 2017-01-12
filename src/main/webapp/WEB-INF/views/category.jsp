<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@ include file="header.jsp" %>

      <div ng-app="app" ng-controller="myController" >
  
<h2 align="center">Add Category</h2>
<br>

    <div class="container">
  <form:form method="POST" modelAttribute="category" action="addCategory">
  
    
        <div class="form-group row">
        <form:label  path="categoryId" class="col-sm-2 col-form-label"></form:label>
              <div class="col-sm-10">
        <form:input type="hidden" path="categoryId" class="form-control"/>
        </div>
    </div>
        
   
    <div class="form-group row">
        <form:label path="categoryName" class="col-sm-2 col-form-label">Category Name</form:label>
              <div class="col-sm-10">
        <form:input path="categoryName" class="form-control" placeholder="Category Name"/>
                <form:errors path="categoryName" class="form-control" cssClass="error"  id="inputError"></form:errors>
              </div>
              </div>
        
          
        <div class="form-group row">
        <form:label path="categoryDescription" class="col-sm-2 col-form-label">category Description</form:label>
                      <div class="col-sm-10">
        <form:input path="categoryDescription" class="form-control" placeholder="Category Description"/>
        <form:errors path="categoryDescription" class="form-control" cssClass="error"  id="inputError" ></form:errors>
     </div>
              </div>
        
    
       <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
                  <input type="submit" value="addCategory" class="btn btn-primary"/>
      
      </div>
    </div>
         
</form:form>
</div>
 
 <div class="alert alert-info">
    
    <p>Search Category: {{ searchCategory }}</p>
    <input type="text" placeholder="Search the category" ng-model="searchCategory">
    
  </div>

<!-- <h2 align="center">Category List</h2> -->
<div class="table-responsive">
    <table class="table">  
    <thead class="thead-default">
        <th>category Id</th>  
        <th>Category Name</th>  
        <th>category description</th>  
        <th >Edit category</th>  
        <th>Delete category</th>  
        </thead>
         
     <tbody>
        <tr ng-repeat="clist in jsonData | orderBy:sortType:sortReverse | filter:searchCategory">  
            <td scope="row">{{clist.categoryId}}</td>  
            <td>{{clist.categoryName}}</td>  
            <td>{{clist.categoryDescription}}</td>  
            <td><a href="editCategory-{{clist.categoryId}}" >Edit</a></td>  
           <td><a href="deleteCategory-{{clist.categoryId}}">Delete</a></td> 
</tr>  
</tbody>
    </table> 
    </div>
    
    <script type="text/javascript">
    var app=angular.module('app',[]);
    app.controller("myController",function($scope){
    	$scope.sortType     = 'categoryName';
    	  $scope.sortReverse  = false; 
    	  $scope.searchCategory   = ''; 
    	$scope.jsonData=${categoryList};
    });
    
    
    
    </script>
   
    
   </div>
   
<%@include file="footer.jsp" %>
