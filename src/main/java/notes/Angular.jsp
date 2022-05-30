<!doctype html>
<html ng-app="demo">
<head>
<title>Hello AngularJS</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<script>
	angular
			.module('demo', [])
			.controller(
					'Hello',
					function($scope, $http) {
						$http
								.get(
										'http://localhost:8090/RESTFreshers/oneemployee')
								.then(function(response) {
									$scope.greeting = response.data;
								});
					});
</script>
</head>

<body>
	<div ng-controller="Hello">
		<p>Emplyee number is : {{greeting.employeeNumber}}</p>
		<p>Employee name is : {{greeting.employeeName}}</p>
	</div>
</body>
</html>
