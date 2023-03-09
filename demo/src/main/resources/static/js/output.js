var app = angular.module('app', []);
app.controller("MainCtrl", function ($scope) {
  $http.get('/overtime').then(function (response) {
    $scope.overtime = response.data;

    console.log($scope.overtime);
  });
});