<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false" %>
<%@ include file="header.jsp" %>

<div ng-app="app" ng-controller="myController">

  <div class="container">
  <form:form method="POST" modelAttribute="subCategory" action="addSubCategory">
  
    
        <div class="form-group row">
        <form:label  path="subCategoryId" class="col-sm-2 col-form-label"></form:label>
              <div class="col-sm-10">
        <form:input type="hidden" path="subCategoryId" class="form-control"/>
        </div>
    </div>
        
   
    <div class="form-group row">
        <form:label path="subCategoryName" class="col-sm-2 col-form-label">Subcategory Name</form:label>
              <div class="col-sm-10">
        <form:input path="subCategoryName" class="form-control" placeholder="Subcategory Name"/>
                <form:errors path="subCategoryName" class="form-control" cssClass="error"  id="inputError"></form:errors>
              </div>
              </div>
        
          
        <div class="form-group row">
        <form:label path="subCategoryDescription" class="col-sm-2 col-form-label">Subcategory Description</form:label>
                      <div class="col-sm-10">
        <form:input path="subCategoryDescription" class="form-control" placeholder="Subcategory Description"/>
        <form:errors path="subCategoryDescription" class="form-control" cssClass="error"  id="inputError" ></form:errors>
     </div>
              </div>
        
           <form:select path="category.categoryName" items="${categoryList}" itemValue="categoryName" itemLabel="categoryName" class="form-control"></form:select>
      <br><br>
          <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
                  <input type="submit" value="addSubcategory" class="btn btn-primary"/>
      
      </div>
    </div>
       
         
</form:form>
</div>

<div class="alert alert-info">
<p>Search SubCategory: {{searchSubCategory}}</p>
<input type="text" placeholder="search the subCategory" ng-model="searchSubCategory">
</div>
      <div class="table-responsive">
    <table  class="table">  
        <caption>SubCategory List</caption>
        <thead class="thead-default">
    
        <th>subcategory Id</th>  
        <th>subCategory Name</th>  
        <th>subcategory description</th>  
        <th>Edit subcategory</th>  
        <th>Delete subcategory</th>  
       </thead>
        
               <tbody>
        <tr ng-repeat="sclist in jsonData | orderBy:sortType:sortReverse | filter:searchSubCategory">  
            <td scope="row">{{sclist.subCategoryId}}</td>  
            <td>{{sclist.subCategoryName}}</td>  
            <td>{{sclist.subCategoryDescription}}</td>  
            <td><a href="editSubCategory-{{sclist.subCategoryId}}" >Edit</a></td>  
           <td><a href="deleteSubCategory-{{sclist.subCategoryId}}">Delete</a></td> 
</tr>  
</tbody>
    
        </table>
        </div>
    
    <script type="text/javascript">
    var app=angular.module('app',[]);
    app.controller("myController",function($scope){
    	$scope.sortType     = 'subCategoryName';
  	  $scope.sortReverse  = false; 
  	  $scope.searchSubCategory   = ''; 
  	
    	$scope.jsonData=${subCategoryList};
    });
    
    </script>
    
    
    
           </div> 

<%@ include file="footer.jsp"%>