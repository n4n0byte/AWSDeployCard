<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
	<title>Card CLC</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">	
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.2.0/css/responsive.dataTables.css">
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<spring:url value="/resources/css/main.css" var="mainCss" />
	<link href="${mainCss}" rel="stylesheet" />
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha256-pasqAKBDmFT4eHoN2ndd6lN370kFiGUFyTiUHWhU7k8="
        crossorigin="anonymous"></script>	
   <script
  src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js"
  integrity="sha256-eGE6blurk5sHj+rmkfsGYeKyZx3M4bG+ZlFyA7Kns7E="
  crossorigin="anonymous"></script>
	<link href="/resources/jquery-ui.css" rel="stylesheet">	
	<script src="/resources/particles.min.js"></script>	
	<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="/resources/overhang.min.css" />
	<script type="text/javascript" src="/resources/overhang.min.js"></script>
	
</head>

<body>
	
	<div>
			<!-- Header -->
	<tiles:insertAttribute name="header" />

	<!-- Body Page -->
	<tiles:insertAttribute name="body" />

	<!-- Footer Page -->
	<tiles:insertAttribute name="footer" />
		
	</div>
	
	
	<div id="bg">
	
	</div>
	
	 <script>
	 	
		particlesJS('bg', {
			  "particles": {
				    "number": {
				      "value": 95,
				      "density": {
				        "enable": true,
				        "value_area": 251.08174384640503
				      }
				    },
				    "color": {
				      "value": "#000000"
				    },
				    "shape": {
				      "type": "circle",
				      "stroke": {
				        "width": 0,
				        "color": "#000000"
				      },
				      "polygon": {
				        "nb_sides": 5
				      },
				      "image": {
				        "src": "img/github.svg",
				        "width": 100,
				        "height": 100
				      }
				    },
				    "opacity": {
				      "value": 1,
				      "random": true,
				      "anim": {
				        "enable": true,
				        "speed": 1,
				        "opacity_min": 0,
				        "sync": false
				      }
				    },
				    "size": {
				      "value": 3,
				      "random": true,
				      "anim": {
				        "enable": false,
				        "speed": 4,
				        "size_min": 0.3,
				        "sync": false
				      }
				    },
				    "line_linked": {
				      "enable": false,
				      "distance": 150,
				      "color": "#ffffff",
				      "opacity": 0.4,
				      "width": 1
				    },
				    "move": {
				      "enable": true,
				      "speed": 1,
				      "direction": "none",
				      "random": true,
				      "straight": false,
				      "out_mode": "out",
				      "bounce": false,
				      "attract": {
				        "enable": false,
				        "rotateX": 600,
				        "rotateY": 600
				      }
				    }
				  },
				  "interactivity": {
				    "detect_on": "window",
				    "events": {
				      "onhover": {
				        "enable": false,
				        "mode": "bubble"
				      },
				      "onclick": {
				        "enable": false,
				        "mode": "repulse"
				      },
				      "resize": true
				    },
				    "modes": {
				      "grab": {
				        "distance": 400,
				        "line_linked": {
				          "opacity": 1
				        }
				      },
				      "bubble": {
				        "distance": 249.99999999999997,
				        "size": 0,
				        "duration": 2,
				        "opacity": 0,
				        "speed": 3
				      },
				      "repulse": {
				        "distance": 400,
				        "duration": 0.4
				      },
				      "push": {
				        "particles_nb": 4
				      },
				      "remove": {
				        "particles_nb": 2
				      }
				    }
				  },
				  "retina_detect": true
				}, function() {			  
			});
	  </script>
	
		
</body>
	<script src="/resources/animations.js"></script>


</html>