<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	
	
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    
	 <link rel="stylesheet" href="css/animate.css">
	
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	<link rel="stylesheet" href="css/magnific-popup.css">

	<link rel="stylesheet" href="css/bootstrap-datepicker.css">
	<link rel="stylesheet" href="css/jquery.timepicker.css">

	
	<link rel="stylesheet" href="css/flaticon.css">
	<link rel="stylesheet" href="css/style.css?v5.3">
	
	
	</head>
	<body>
	
	 
 <script type='text/javascript'>
 function validarForm(){
	 
	    var obj2 = document.forms.prueba.ingredientes;

	    var obj1 = document.forms.prueba.ingredientes1;

		for (var i=0; opt=obj1.options[i]; i++){
	    if (opt.selected) {
	        var valor=opt.value; // almacenar value
	        var txt=obj1.options[i].text; // almacenar el texto
	        
 	  		var opc = new Option(txt,valor,false,true);   
	    
 	        eval(obj2.options[obj2.options.length]=opc);    
	  	}
		}
		
		
	    var obj22 = document.forms.prueba.ingredientes2;

		for (var i=0; opt=obj22.options[i]; i++){
	    if (opt.selected) {
	        var valor=opt.value; // almacenar value
	        var txt=obj22.options[i].text; // almacenar el texto
 	  		var opc = new Option(txt,valor,false,true);   
	    
 	        eval(obj2.options[obj2.options.length]=opc);    
	  	} 
		}
		
	    var obj3 = document.forms.prueba.ingredientes3;

		for (var i=0; opt=obj3.options[i]; i++){
	    if (opt.selected) {
	        var valor=opt.value; // almacenar value
	        var txt=obj3.options[i].text; // almacenar el texto
 	  		var opc = new Option(txt,valor,false,true);   
	    
 	        eval(obj2.options[obj2.options.length]=opc);    
	  	} 
		}
		
	    var obj4 = document.forms.prueba.ingredientes4;

		for (var i=0; opt=obj4.options[i]; i++){
	    if (opt.selected) {
	        var valor=opt.value; // almacenar value
	        var txt=obj4.options[i].text; // almacenar el texto
	  		var opc = new Option(txt,valor,false,true);   
	    
 	        eval(obj2.options[obj2.options.length]=opc);    
	  	} 
		}
		
	 
	    var obj5 = document.forms.prueba.ingredientes5;

		for (var i=0; opt=obj5.options[i]; i++){
	    if (opt.selected) {
	        var valor=opt.value; // almacenar value
	        var txt=obj5.options[i].text; // almacenar el texto
 	  		var opc = new Option(txt,valor,false,true);   
	    
 	        eval(obj2.options[obj2.options.length]=opc);    
	  	} 
		}
 	  if(document.forms.prueba.ingredientes.value==""){
 			
  
	  		var opc = new Option("","",false,true);   
	    
	        eval(obj2.options[obj2.options.length]=opc);    
 	  }
 	  
	 return true;
	   
	}
	</script>

	
		
	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="index.html">App.<span>UNLAM</span></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="index.html" class="nav-link">Indice Masa Muscular</a></li>
					<li class="nav-item"><a href="about.html" class="nav-link">¿Que puedo cocinar?</a></li> 
				</ul>
			</div>
		</div>
	</nav>
	<!-- END nav -->
	
	<section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_5.jpg');" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text justify-content-center" style="    margin-top: 9em;">
				<div class="col-md-9 ftco-animate text-center mb-5">
					<h1 class="mb-2 bread"> APP UNLAM</h1>
					<p class="breadcrumbs"><span class="mr-2"><a href="">Seleccione sus ingredientes
 </a></span>  </p>
				</div>
			</div>
		</div>
	</section>
	
	
		<section class="ftco-section bg-light">
		<div class="container">
			<div class="row justify-content-center mb-5 pb-2">
				<div class="col-md-7 text-center heading-section ftco-animate">
				
				
				   <c:if test="${not empty msj}">
                <div class="alert alert-warning" role="alert">
                    <p>${msj}</p>
                </div>
            </c:if>	
            
            
 					<h2 class="mb-4">Seleccione sus ingredientes</h2>
				</div>
			</div>	
			<div class="row">
			
            
            
<form class="" name="prueba"  action="busco-plato"  onsubmit="return validarForm();" style="width: 100%;">
 
<select name="ingredientes[]" id="ingredientes" multiple style="display:none"></select>
 








   
 		
            
				<div class="col-md-6 col-lg-2 ftco-animate">
					<div class="staff">
						<div class="img" style="background-image: url(images/verduras.jpg);"></div>
						<div class="text px-4 pt-2">
							<h3>Frutas y Verduras</h3>
							<div class="faded">
				 <select name="ingredientes1[]" id="ingredientes1" multiple>
				 <c:forEach var="verduras" items="${verduras}">
				 <option value="<c:out value="${verduras.id}"/>">
				  <c:out value="${verduras.nombre}"/>
				  </option>
				</c:forEach>
				</select>

							</div>
						</div>
					</div>
				</div>
				
				
								<div class="col-md-6 col-lg-2 ftco-animate">
					<div class="staff">
						<div class="img" style="background-image: url(images/lunch-7.jpg);"></div>
						<div class="text px-4 pt-2">
							<h3>Carnes</h3>
							<div class="faded">
							 <select name="ingredientes2[]" id="ingredientes2" multiple>
						 <c:forEach var="carnes" items="${carnes}">
						 <option value="<c:out value="${carnes.id}"/>">
						  <c:out value="${carnes.nombre}"/>
						  </option>
						</c:forEach>
						</select>

							</div>
						</div>
					</div>
				</div>
				
				
								<div class="col-md-6 col-lg-2 ftco-animate">
					<div class="staff">
						<div class="img" style="background-image: url(images/lacteos.jpg);"></div>
						<div class="text px-4 pt-2">
							<h3>Lacteos</h3>
							<div class="faded">
				 <select name="ingredientes3[]"  id="ingredientes3"  multiple>
				 <c:forEach var="lacteos" items="${lacteos}">
				 <option value="<c:out value="${lacteos.id}"/>">
				  <c:out value="${lacteos.nombre}"/>
				  </option>
				</c:forEach>
				</select>


							</div>
						</div>
					</div>
				</div>
				
				
								<div class="col-md-6 col-lg-2 ftco-animate">
					<div class="staff">
						<div class="img" style="background-image: url(images/harinas.jpg);"></div>
						<div class="text px-4 pt-2">
							<h3>Harinas</h3>
							<div class="faded">
		
					 <select name="ingredientes4[]" id="ingredientes4"  multiple>
					 <c:forEach var="harinas" items="${harinas}">
					 <option value="<c:out value="${harinas.id}"/>">
					  <c:out value="${harinas.nombre}"/>
					  </option>
					</c:forEach>
					</select>

							</div>
						</div>
					</div>
				</div>
				
								<div class="col-md-6 col-lg-2 ftco-animate">
					<div class="staff">
						<div class="img" style="background-image: url(images/conservas.png);"></div>
						<div class="text px-4 pt-2">
							<h3>Conservas</h3>
							<div class="faded">
			
				 <select name="ingredientes5[]" id="ingredientes5"  multiple>
				 <c:forEach var="conservas" items="${conservas}">
				 <option value="<c:out value="${conservas.id}"/>">
				  <c:out value="${conservas.nombre}"/>
				  </option>
				</c:forEach>
				</select>

							</div>
						</div>
					</div>
				</div>
	<div class="col-md-12 col-lg-12 ftco-animate" style=" margin-top: 5em;text-align: center;">
			
			     <button type="submit" class="btn btn-success" >Buscar Plato</button>
			     	</div>
 		</form>		  
 		
 		
 		
			</div>
		</div>
	</section>
	
		<footer class="ftco-footer ftco-no-pb ftco-section">
			<div class="container">
				<div class="row mb-5">
					<div class="col-md-6 col-lg-3">
						<div class="ftco-footer-widget mb-4">
							<h2 class="ftco-heading-2">APP UNLAM</h2>
							<p>Introducción a la App.</p>
							<ul class="ftco-footer-social list-unstyled float-md-left float-lft mt-3">
								<li class="ftco-animate"><a href="#"><span class="fa fa-twitter"></span></a></li>
								<li class="ftco-animate"><a href="#"><span class="fa fa-facebook"></span></a></li>
								<li class="ftco-animate"><a href="#"><span class="fa fa-instagram"></span></a></li>
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-lg-3">
						<div class="ftco-footer-widget mb-4">
							<h2 class="ftco-heading-2">Pasos</h2>
							<ul class="list-unstyled open-hours">
								<li class="d-flex"><span>1 Seleccionar Ingrediente</span></li> 
								<li class="d-flex"><span>2 Seleccionar Plato</span></li> 
								<li class="d-flex"><span>3 Ver Receta</span></li> 
							</ul>
						</div>
					</div>
					<div class="col-md-6 col-lg-3">
						<div class="ftco-footer-widget mb-4">
							<h2 class="ftco-heading-2">Platos</h2>
							<div class="thumb d-sm-flex">
								<a href="#" class="thumb-menu img" style="background-image: url(images/insta-1.jpg);">
								</a>
								<a href="#" class="thumb-menu img" style="background-image: url(images/insta-2.jpg);">
								</a>
								<a href="#" class="thumb-menu img" style="background-image: url(images/insta-3.jpg);">
								</a>
							</div>
							<div class="thumb d-flex">
								<a href="#" class="thumb-menu img" style="background-image: url(images/insta-4.jpg);">
								</a>
								<a href="#" class="thumb-menu img" style="background-image: url(images/insta-5.jpg);">
								</a>
								<a href="#" class="thumb-menu img" style="background-image: url(images/insta-6.jpg);">
								</a>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-lg-3">
						<div class="ftco-footer-widget mb-4">
							<h2 class="ftco-heading-2">Comentarios</h2>
							<p>Calcular Indice Masa Moscular</p>
							<form action="#" class="subscribe-form">
								<div class="form-group">
									<input type="text" class="form-control mb-2 text-center" placeholder="Peso/Medida">
									<input type="submit" value="Calcular" class="form-control submit px-3">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="container-fluid px-0 bg-primary py-3">
				<div class="row no-gutters">
					<div class="col-md-12 text-center">

						<p class="mb-0">Sitio diseñado y desarrollado por Alumnos de Taller 1</p>
						</div>
					</div>
				</div>
			</footer>
			

			<!-- loader -->
			<div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


			<script src="js/jquery.min.js"></script>
			<script src="js/jquery-migrate-3.0.1.min.js"></script>
			<script src="js/popper.min.js"></script>
			<script src="js/bootstrap.min.js"></script>
			<script src="js/jquery.easing.1.3.js"></script>
			<script src="js/jquery.waypoints.min.js"></script>
			<script src="js/jquery.stellar.min.js"></script>
			<script src="js/owl.carousel.min.js"></script>
			<script src="js/jquery.magnific-popup.min.js"></script>
			<script src="js/jquery.animateNumber.min.js"></script>
			<script src="js/bootstrap-datepicker.js"></script>
			<script src="js/jquery.timepicker.min.js"></script>
			<script src="js/scrollax.min.js"></script>
			<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
			<script src="js/google-map.js"></script>
			<script src="js/main.js"></script>
			
		</body>
		</html>
 
	 