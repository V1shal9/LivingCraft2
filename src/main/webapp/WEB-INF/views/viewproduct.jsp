<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="header.jsp" %>

<div ng-app="app" ng-controller="myController" >

		<div class="product">
			<div class="container">
				<div class="col-md-3 product-price">
					  
				<div class=" rsidebar span_1_of_left">
					<div class="of-left">
						<h3 class="cate">CATEGORIES</h3>
					</div>
		 <ul class="menu">
		<li class="item1"><a href="#">{{jsonData.categoryName}}</a>
			<ul class="cute">
				<li class="subitem1"><a href="#">Cute Kittens </a></li>
				<li class="subitem2"><a href="#">Strange Stuff </a></li>
				<li class="subitem3"><a href="#">Automatic Fails </a></li>
			</ul>
		</li>
		<li class="item2"><a href="#">Craft </a>
			<ul class="cute">
				<li class="subitem1"><a href="#">Cute Kittens </a></li>
				<li class="subitem2"><a href="#">Strange Stuff </a></li>
				<li class="subitem3"><a href="#">Automatic Fails </a></li>
			</ul>
		</li>
		<li class="item3"><a href="#">Home Decoration</a>
			<ul class="cute">
				<li class="subitem1"><a href="#">Cute Kittens </a></li>
				<li class="subitem2"><a href="#">Strange Stuff </a></li>
				<li class="subitem3"><a href="#">Automatic Fails </a></li>
			</ul>
		</li>
		<li class="item4"><a href="#">Accesories</a>
			<ul class="cute">
				<li class="subitem1"><a href="#">Cute Kittens </a></li>
				<li class="subitem2"><a href="#">Strange Stuff </a></li>
				<li class="subitem3"><a href="#">Automatic Fails </a></li>
			</ul>
		</li>
				
		<li class="item4"><a href="#">Jewellery</a>
			<ul class="cute">
				<li class="subitem1"><a href="#">Cute Kittens </a></li>
				<li class="subitem2"><a href="#">Strange Stuff </a></li>
				<li class="subitem3"><a href="#">Automatic Fails </a></li>
			</ul>
		</li>
	</ul>
					</div>
				<!--initiate accordion-->
		<script type="text/javascript">
			$(function() {
			    var menu_ul = $('.menu > li > ul'),
			           menu_a  = $('.menu > li > a');
			    menu_ul.hide();
			    menu_a.click(function(e) {
			        e.preventDefault();
			        if(!$(this).hasClass('active')) {
			            menu_a.removeClass('active');
			            menu_ul.filter(':visible').slideUp('normal');
			            $(this).addClass('active').next().stop(true,true).slideDown('normal');
			        } else {
			            $(this).removeClass('active');
			            $(this).next().stop(true,true).slideUp('normal');
			        }
			    });
			
			});
		</script>

				<!---->
				<div class="product-bottom">
					<div class="of-left-in">
								<h3 class="best">BEST SELLERS</h3>
							</div>
					<div class="product-go">
						<div class=" fashion-grid">
									<a href="#"><img class="img-responsive " src="images/be.jpg" alt=""></a>
									
								</div>
							<div class=" fashion-grid1">
								<h6 class="best2"><a href="#" >Lorem ipsum dolor sit
amet consectetuer  </a></h6>
								
								<span class=" price-in1"> $40.00</span>
							</div>
								
							<div class="clearfix"> </div>
							</div>
							<div class="product-go">
						<div class=" fashion-grid">
									<a href="#"><img class="img-responsive " src="images/be1.jpg" alt=""></a>
									
								</div>
							<div class="fashion-grid1">
								<h6 class="best2"><a href="#" >Lorem ipsum dolor sit
amet consectetuer </a></h6>
								
								<span class=" price-in1"> $40.00</span>
							</div>
								
							<div class="clearfix"> </div>
							</div>
							<div class="product-go">
						<div class=" fashion-grid">
									<a href="#"><img class="img-responsive " src="images/be2.jpg" alt=""></a>
									
								</div>
							<div class=" fashion-grid1">
								<h6 class="best2"><a href="#" >Lorem ipsum dolor sit
amet consectetuer </a></h6>
								<ul class="star-footer">
									<li><a href="#"><i> </i></a></li>
									<li><a href="#"><i> </i></a></li>
									<li><a href="#"><i> </i></a></li>
									<li><a href="#"><i> </i></a></li>
									<li><a href="#"><i> </i></a></li>
								</ul>
								<span class=" price-in1"><small>$70.00</small> $40.00</span>
							</div>
								
							<div class="clearfix"> </div>
							</div>
				</div>
<div class=" per1">
				<img class="img-responsive" src="images/pro.jpg" alt="">
				<div class="six1">
					<h4>DISCOUNT</h4>
					<p>Up to</p>
					<span>60%</span>
				</div>
			</div>
				</div>
				<!---->
				<div class="col-md-9 product-price1">
				<div class="col-md-5 single-top" >	
						<ul id="etalage">
							<li>
								<a href="optionallink.html">
									<img class="etalage_thumb_image img-responsive"  src="resources/images/{{jsonData.productId}}-1.jpg" alt="" >
									<img class="etalage_source_image img-responsive" src="resources/images/{{jsonData.productId}}-1.jpg" alt="" >
								</a>
							</li>
							<li>
								<img class="etalage_thumb_image img-responsive" src="resources/images/{{jsonData.productId}}-2.jpg" alt="" >
								<img class="etalage_source_image img-responsive" src="resources/images/{{jsonData.productId}}-2.jpg" alt="" >
							</li>
							<li>
								<img class="etalage_thumb_image img-responsive" src="resources/images/{{jsonData.productId}}-3.jpg" alt=""  >
								<img class="etalage_source_image img-responsive" src="resources/images/{{jsonData.productId}}-3.jpg" alt="" >
							</li>
						    <li>
								<img class="etalage_thumb_image img-responsive" src="resources/images/{{jsonData.productId}}-4.jpg"  alt="" >
								<img class="etalage_source_image img-responsive" src="resources/images/{{jsonData.productId}}-4.jpg" alt="" >
							</li>
						</ul>

					</div>	
					<div class="col-md-7 single-top-in simpleCart_shelfItem">
						<div class="single-para ">
						<h4>{{jsonData.productName}}</h4>
							<div class="star-on">
								<ul class="star-footer">
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
										<li><a href="#"><i> </i></a></li>
									</ul>
								<div class="review">
									<a href="#"> 1 customer review </a>
									
								</div>
							<div class="clearfix"> </div>
							</div>
							
							<h5 class="item_price">$ {{jsonData.productPrice}}</h5>
							<p>{{jsonData.productDescription}}</p>
							<div class="available">
								<ul>
									<li>Color
										<select>
										<option>Silver</option>
										<option>Black</option>
										<option>Dark Black</option>
										<option>Red</option>
									</select></li>
								<li class="size-in">Size<select>
									<option>Large</option>
									<option>Medium</option>
									<option>small</option>
									<option>Large</option>
									<option>small</option>
								</select></li>
							</ul>
						</div>
							<ul class="tag-men">
								<li><span>Quantity</span>
								<span class="women1">: {{jsonData.productQuantity}}</span></li>
								<li><span>Discount</span>
								<span class="women1">: {{jsonData.productDiscount}}</span></li>
							</ul>
								<a href="buynow-{{jsonData.productId}}?userId=1" class="add-cart item_add">BUY NOW</a>
							
						</div>
					</div>
				<div class="clearfix"> </div>
			<!---->
					<div class="cd-tabs">
			<nav>
				<ul class="cd-tabs-navigation">
					<li><a data-content="fashion"  href="#0">Description </a></li>
					<li><a data-content="cinema" href="#0" >Addtional Informatioan</a></li>
					<li><a data-content="television" href="#0" class="selected ">Reviews (1)</a></li>
					
				</ul> 
			</nav>
	<ul class="cd-tabs-content">
		<li data-content="fashion" >
		<div class="facts">
							        </div>

</li>
<li data-content="cinema" >
		<div class="facts1">
					
						<div class="color"><p>Color</p>
							<span >Blue, Black, Red</span>
							<div class="clearfix"></div>
						</div>
						<div class="color">
							<p>Size</p>
							<span >S, M, L, XL</span>
							<div class="clearfix"></div>
						</div>
					        
			 </div>

</li>
<li data-content="television" class="selected">
	<div class="comments-top-top">
				<div class="top-comment-left">
					<img class="img-responsive" src="images/co.png" alt="">
				</div>
				<div class="top-comment-right">
					<h6><a href="#">Hendri</a> - September 3, 2014</h6>
				
									<p>Wow nice!</p>
				</div>
				<div class="clearfix"> </div>
				<a class="add-re" href="#">ADD REVIEW</a>
			</div>

</li>
<div class="clearfix"></div>
	</ul> 
</div> 
			<!---->
		       
		        	<div class="top-product">
					<h3 class="real">RELETED PRODUCTS</h3>
		        	
		        		<div class="col-md-4 chain-grid  simpleCart_shelfItem">
		        			<div class="grid-span-1">
	   		     		<a  href="single.html"><img class="img-responsive " src="resources/images/p1.jpg" alt=" ">
	   		     			<div class="link">
	   		     			<ul >
										<li><i> </i></li>
										<li><i class="white1"> </i></li>
										
							</ul>
	   		     		</div>
	   		     		</a>
	   		     	</div>
	   		     		<div class="grid-chain-bottom ">
	   		     			<h6><a href="single.html">Old Piano</a></h6>
	   		     			<div class="star-price">
	   		     				
									<div class="price-at-bottom ">
										<span class="item_price">$ 75.00</span>
									</div>
	   		     				<div class="clearfix"> </div>
							</div>
							<div class="cart-add">
								<a class="add1 item_add" href="#">ADD TO CART <i> </i></a>
								<a class="add2" href="#"><i> </i></a>
								<div class="clearfix"> </div>
							</div>
	   		     		</div>
	   		     		
	   		     	</div>
	   		     	<div class="col-md-4 chain-grid simpleCart_shelfItem">
					<div class="grid-span-1">
	   		     		<a href="single.html"><img class="img-responsive " src="resources/images/p3.jpg" alt=" ">
						<div class="link">
	   		     			<ul >
										<li><i> </i></li>
										<li><i class="white1"> </i></li>
										
							</ul>
	   		     		</div></a>
	   		     		</div>
	   		     		<div class="grid-chain-bottom ">
	   		     			<h6><a href="single.html">Vintage car</a></h6>
	   		     			<div class="star-price">
	   		     				
									<div class="price-at-bottom ">
										<span class="item_price">$ 75.00</span>
									</div>
	   		     				<div class="clearfix"> </div>
							</div>
							<div class="cart-add">
								<a class="add1 item_add" href="#">ADD TO CART <i> </i></a>
								<a class="add2" href="#"><i> </i></a>
								<div class="clearfix"> </div>
							</div>
	   		     		</div>
	   		     	</div>
	   		     	<div class="col-md-4 chain-grid simpleCart_shelfItem">
					<div class="grid-span-1">
	   		     		<a href="single.html"><img class="img-responsive " src="resources/images/p6.jpg" alt=" ">
						<div class="link">
	   		     			<ul >
										<li><i> </i></li>
										<li><i class="white1"> </i></li>
										
							</ul>
	   		     		</div></a>
	   		     		</div>
	   		     		<div class="grid-chain-bottom ">
	   		     			<h6><a href="single.html">Antique Watch</a></h6>
	   		     			<div class="star-price">
	   		     				
									<div class="price-at-bottom ">
										<span class="item_price">$ 75.00</span>
									</div>
	   		     				<div class="clearfix"> </div>
							</div>
							<div class="cart-add">
								<a class="add1 item_add" href="#">ADD TO CART <i> </i></a>
								<a class="add2" href="#"><i> </i></a>
								<div class="clearfix"> </div>
							</div>
	   		     		</div>
	   		     
		        	</div>
	   		     	<div class="clearfix"> </div>
		        	</div>
		     
		      
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
			<!---->
			<div class="bottom-grid1">
					
					<div class="fit1">
						<h3>HAPPY SHOPPING</h3>
						<p>Living Craft</p>
					</div>
				</div>
				
					        	<div class="top-product">
	<script type="text/javascript">
    var app=angular.module('app',[]);
    app.controller("myController",function($scope){
    	$scope.jsonData=${product};
    });
    
    
    </script></div>		



<%@ include file="footer.jsp" %>




