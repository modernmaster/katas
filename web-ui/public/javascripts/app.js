angular.module("app", ["app.tpl", "ui.router", "hc.marked", "toaster"]);

angular.module("app").config(["$httpProvider", function ($httpProvider) {

  $httpProvider.defaults.headers.common = {
    "X-Requested-With" : "XMLHttpRequest"
  };

}]);

angular.module("app").config(["$locationProvider", "$stateProvider", "$urlRouterProvider", function ($locationProvider, $stateProvider, $urlRouterProvider) {

  $locationProvider.html5Mode({
    enabled: true,
    requireBase: false
  });

}]);

angular.module("app").controller("main-index.controller", ["$scope", function($scope) {

}]);

angular.module("app").controller("main-sub.controller", ["$scope", function ($scope) {

}]);

angular.module("app").config(["$stateProvider", function ($stateProvider) {

  $stateProvider
    .state({
      name: "main-index",
      url: "/",
      templateUrl: "/main/main-index.tpl.html",
      controller: "main-index.controller"
    })
    .state({
      name: "main-sub",
      url: "/sub",
      templateUrl: "/main/main-sub.tpl.html",
      controller: "main-sub.controller"
    });

}]);
