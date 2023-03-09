var app = angular.module('app', []);
app.controller("MainCtrl", function ($scope, $http) {
  $http.get('/overtime').then(function (response) {
    $scope.search = null;
    $scope.overtime = response.data;
    console.log($scope.overtime);
  }, function (error) {
    console.log('Error fetching overtime data:', error);
  });
});