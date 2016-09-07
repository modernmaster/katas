angular.module("app", ["app.tpl", "ui.router", "hc.marked", "toaster"]);

angular.module("app").config(function ($httpProvider) {

  $httpProvider.defaults.headers.common = {
    "X-Requested-With" : "XMLHttpRequest"
  };

});

angular.module("app").config(function ($locationProvider, $stateProvider, $urlRouterProvider) {

  $locationProvider.html5Mode({
    enabled: true,
    requireBase: false
  });

});
