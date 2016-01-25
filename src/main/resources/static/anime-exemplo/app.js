angular.module('app', ["ui.router", "ngAnimate"]);

angular.module('app').config(function($stateProvider, $urlRouterProvider){    
      $stateProvider
          .state("foo", {
              url: "/foo",
              template: '<h1>foo</h1>'
          })
          .state("bar", {
              url: "/bar",
              template: '<h1>bar</h1>'
          })
      
      $urlRouterProvider.otherwise("/foo");
});

angular.module('app').config(['$stateProvider', '$urlRouterProvider', function ($r, $t) {

        $t.when('/dash', '/dash/over');
		
		$t.otherwise('/login'), 
		
		$r.state('base', {
            'abstract': !0,
            url: '',
            templateUrl: 'views/base.html'
        }).state('login', {
            url: '/login',
            parent: 'base',
            templateUrl: 'views/login.html',
            controller: 'LoginController'
        }).state('dash', {
            url: '/dash',
            parent: 'base',
            templateUrl: 'views/dash.html',
            controller: 'DashController'
        }).state('over', {
            url: '/over',
            parent: 'dash',
            templateUrl: 'views/over.html',
            controller: 'OverController'
        })
    }]);
    
    