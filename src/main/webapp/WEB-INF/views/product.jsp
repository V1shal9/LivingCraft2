<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="header.jsp" %>

<div ng-app="app" ng-controller="myController">

<form:form method="post" modelAttribute="product" action="addProduct" enctype="multipart/form-data" >



    <div class="container">  
    
        <div class="form-group row">
        <form:label  path="categoryId" class="col-sm-2 col-form-label"></form:label>
              <div class="col-sm-10">
        <form:input type="hidden" path="productId" class="form-control"/>
        </div>
    </div>
        
   
    <div class="form-group row">
        <form:label path="productName" class="col-sm-2 col-form-label">Product Name</form:label>
              <div class="col-sm-10">
        <form:input path="productName" class="form-control" placeholder="product Name"/>
                <form:errors path="productName" class="form-control" cssClass="error"  id="inputError"></form:errors>
              </div>
              </div>
        
          
        <div class="form-group row">
        <form:label path="productDescription" class="col-sm-2 col-form-label">product Description</form:label>
                      <div class="col-sm-10">
        <form:input path="productDescription" class="form-control" placeholder="product Description"/>
        <form:errors path="productDescription" class="form-control" cssClass="error"  id="inputError" ></form:errors>
     </div>
              </div>
              
         <div class="form-group row">
        <form:label path="productQuantity" class="col-sm-2 col-form-label">product Quantity</form:label>
                      <div class="col-sm-10">
        <form:input path="productQuantity" class="form-control" placeholder="product quantity"/>
        <form:errors path="productQuantity" class="form-control" cssClass="error"  id="inputError" ></form:errors>
     </div>
              </div>
        
        
          <div class="form-group row">
        <form:label path="productPrice" class="col-sm-2 col-form-label">product Price</form:label>
                      <div class="col-sm-10">
        <form:input path="productPrice" class="form-control" placeholder="product Price"/>
        <form:errors path="productPrice" class="form-control" cssClass="error"  id="inputError" ></form:errors>
     </div>
              </div>
              
              
            <div class="form-group row">
        <form:label path="productDiscount" class="col-sm-2 col-form-label">product Discount</form:label>
                      <div class="col-sm-10">
        <form:input path="productDiscount" class="form-control" placeholder="product Discount"/>
        <form:errors path="productDiscount" class="form-control" cssClass="error"  id="inputError" ></form:errors>
     </div>
              </div>
             
             
            <div class="form-group row">
        <form:label path="productImage" class="col-sm-2 col-form-label">product Image</form:label>
                      <div class="col-sm-10">
        <input  class="form-control"  type="file" name="file" multiple="multiple"/>
        <form:errors path="productImage" class="form-control" cssClass="error"  id="inputError" ></form:errors>
     </div>
              </div> 
              
              <form:select path="category.categoryName" items="${categoryList}" itemValue="categoryName" itemLabel="categoryName" class="form-control"></form:select>
      <br>
         
      
                 <form:select path="subCategory.subCategoryName" items="${subCategoryList}" itemValue="subCategoryName" itemLabel="subCategoryName" class="form-control"></form:select>
      <br>
     
      
               <form:select path="supplier.supplierName" items="${supplierList}" itemValue="supplierName" itemLabel="supplierName" class="form-control"></form:select>
      <br>
        
              
      <div class="form-group row">
      <div class="offset-sm-2 col-sm-10">
                  <input type="submit" value="addProduct" class="btn btn-primary"/>
      
      </div>
    </div>
         
</form:form>
</div>

<div class="alert alert-info">
<p>Search Product: {{searchProduct}}</p>
<input type="text" placeholder="search the product" ng-model="searchProduct">
</div>

<h3>Product List</h3> 
<div class="table-responsive">
    <table class="table">  
    <thead class="thead-default"><tr> 
<th width="80">Product Id</th> 
<th width="120">Product Name</th> 
<th width="120">Product description</th> 
<th width="120">product quantity</th>  
<th width="120">product price</th>  
<th width="120">product discount</th> 
<th width="80">Edit</th> 
<th width="80">Delete</th> 
<th width="80">Add Info</th> 

</tr>
<%-- <c:forEach items="${productList}" var="plist">  --%>
<tr ng-repeat="plist in jsonData | orderBy:sortType:sortReverse | filter:searchProduct">
<td>{{plist.productId}}</td> 
<td>{{plist.productName}}</td> 
<td>{{plist.productDescription}}</td> 
<td>{{plist.productQuantity}}</td> 
<td>{{plist.productPrice}}</td> 
<td>{{plist.productDiscount}}</td> 

<td><a href="editProduct-{{plist.productId}}" >Edit</a></td> 
<td><a href="deleteProduct-{{plist.productId}}">Delete</a></td> 
<td><a href="deleteProduct-{{plist.productId}}">Add Info</a></td> 

</tr> 

</table> 
<script type="text/javascript">
  var app=angular.module('app',[])
  app.controller("myController",function($scope)
  {
 	 $scope.sortType='subProduct';
 	 $scope.sortReverse =false;
 	 $scope.jsonData= ${productList};
	 
  });
</script>

</div>

<%@ include file="footer.jsp"%>