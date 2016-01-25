!function ($, jQuery) {
	
'use strict';

angular.module('app', [
	
	'ui.router', 
	'ngSanitize',
	'ngAnimate',
	'nya.bootstrap.select',
   	'daterangepicker',
	'maskMoney'	,
	'ui.grid',
	'ui.grid.pagination',
	'ui.grid.cellNav',
	'ui.grid.moveColumns'

]);


angular.module('app').run(function ($rootScope, $state) {
   
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
        }).state('wiz', {
            url: '/wiz',
            parent: 'dash',
            templateUrl: 'views/wizard.html'
        }).state('wiz1', {
            url: '/wiz1',
            parent: 'wiz',
            templateUrl: 'views/w1.fatura.html',
            controller: 'MainController'
        }).state('wiz2', {
            url: '/wiz2',
            parent: 'wiz',
            templateUrl: 'views/w2.fatura.html',
            controller: 'MainController'
        }).state('wiz3', {
            url: '/wiz3',
            parent: 'wiz',
            templateUrl: 'views/w3.fatura.html',
            controller: 'MainController'
        }).state('wiz4', {
            url: '/wiz4',
            parent: 'wiz',
            templateUrl: 'views/w4.fatura.html',
            controller: 'MainController'
        }).state('wiz5', {
            url: '/wiz5',
            parent: 'wiz',
            templateUrl: 'views/w5.fatura.html',
            controller: 'MainController'
        });
}]);
    
angular.module('app').controller('MenuController',function($scope){
	
	
	 
	
	 //skin-purple sidebar-mini sidebar-collapse sidebar-open --- mini
	 //skin-purple sidebar-mini sidebar-open --opn
	 //skin-purple sidebar-mini
	
});    


angular.module('app').controller('DashController',function($http,$scope){
	
});
angular.module('app').controller('OverController',function($http,$scope){
	
});
angular.module('app').controller('LoginController',function($scope,$location){
	
	$scope.login = function () {
		return $location.path('/dash'), !1;
	};
	
});


angular.module('app').controller('MainController',function($scope){

	$scope.pdv={id:1,descricao:"PDVl 1"};
	$scope.pdvs=[{id:1,descricao:"PDV 1"},{id:2,descricao:"PDV 2"}];


	$scope.filial={id:1,descricao:"Filial 1"};
	$scope.filiais=[{id:1,descricao:"Filial 1"},{id:2,descricao:"Filial 2"}];

	$scope.departamento={id:1,descricao:"Filial 1"};
	$scope.departamentos=[{id:1,descricao:"Departamento 1"},{id:2,descricao:"Departamento 2"}];
	
	
	$scope.plano={};
	$scope.planos=[
	{ id:1,descricao:'Milho 2015'},
	{ id:2,descricao:'Soja 2015'},
	{ id:3,descricao:'Arroz 2015'},
	{ id:4,descricao:'Feijão 2015'},
	{ id:5,descricao:'Algodão 2015'}
	];


	$scope.moeda={};
	$scope.moedas=[
	{ id:1,descricao:'Guarani'},
	{ id:2,descricao:'Dolar'},
	{ id:3,descricao:'Real'},
	{ id:4,descricao:'Euro'}
	];


	$scope.condicao={};
	$scope.condicoes=[
	{ id:1,descricao:'Ao Contado'},
	{ id:2,descricao:'A Credito'},
	{ id:3,descricao:'Donaciones'},
	{ id:4,descricao:'Promociones'}
	];


	$scope.processo={};
	$scope.processos=[
	{ id:1,descricao:'Factura normal'},
	{ id:2,descricao:'Nota de extorno'},
	{ id:3,descricao:'Factura totalizadora'},
	{ id:4,descricao:'Nota Recepción'},
	{ id:5,descricao:'Simple remesa'}
	];
	
	$scope.enidades={};
	$scope.entidades=[
	{ id:1,descricao:'Adriano Arantes'},
	{ id:2,descricao:'Joni Nunes'},
	{ id:3,descricao:'Lyndon Tavares'},
	{ id:4,descricao:'Willian Cássio'}
	];
	
	$scope.modalidade={};
	$scope.modalidades=[
	{ id:1,descricao:'Boleta de venta IVA incl'},
	{ id:2,descricao:'Boleta de venta IVA desc'},
	{ id:3,descricao:'Factura IVA incl'},
	{ id:4,descricao:'Factura IVA descriminado'},
	{ id:5,descricao:'INMAGRO'},
	{ id:6,descricao:'Tributo unico'}
	];
	
	$scope.pessoa={
		 nome:'Lyndon Tavares',
		 endereco:'Rua Osvaldo Goch, 1190',
		 telefone:'4599024011',
		 email:'integraldominio@gmail.com',
		 cargo:'Desenvolvedor Java',
		 salario:999.99,
		 senha:""};
	
	
	 //periodo
    $scope.periodo = {
        startDate: moment().subtract(1,"days"),
        endDate: moment()
    };


	//data simple
	//singleDatePicker: true
	$scope.optSimples = {
		singleDatePicker: true, 
	    format: 'DD/MM/YYYY',
	    locale: {
	        applyClass: 'btn-green',
	        applyLabel: "Aplicar",
	        fromLabel: "De",
	        toLabel: "Hasta",
	        cancelLabel: 'Cancelar',
	        customRangeLabel: 'Especificar',
	        daysOfWeek: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'],
	        firstDay: 1,
	        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Jullo', 'Agosto', 'Septiembre',
	            'Octubre', 'Noviembre', 'Diciembre'
	        ]
	    }

	};




	// opções do periodo de datas
	$scope.opts = {
	    format: 'DD/MM/YYYY',
	    locale: {
	        applyClass: 'btn-green',
	        applyLabel: "Aplicar",
	        fromLabel: "De",
	        toLabel: "Hasta",
	        cancelLabel: 'Cancelar',
	        customRangeLabel: 'Especificar',
	        daysOfWeek: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'],
	        firstDay: 1,
	        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Jullo', 'Agosto', 'Septiembre',
	            'Octubre', 'Noviembre', 'Diciembre'
	        ]
	    },
	    ranges: {
	        'Hoy': [moment(), moment()],
	        'Últimos 7 días': [moment().subtract(6,'days'), moment()],
	        'Últimos 30 días': [moment().subtract(29,'days'), moment()]
	    }
	};


      $scope.valor1 = 1;    
      $scope.valor2 = 2;    
      $scope.valor3 = 3;    
      $scope.valor4 = 4;    

    $scope.setValue = function(){
    }; 
    
    $scope.options1 = {
            prefix: 'R$  ',
            thousands:'.', 
            decimal:',',
            precision:4
        }
    $scope.options2 = {
            prefix: 'G$  ',
            thousands:'.', 
            decimal:',',
            precision:0
        }
    $scope.options3 = {
            prefix: 'US$  ',
            thousands:'.', 
            decimal:',',
            precision:2
        }
    $scope.options4 = {
            prefix: 'E$  ',
            thousands:'.', 
            decimal:',',
            precision:6
        }

    $scope.options5 = {
            prefix: '',
            thousands:'.', 
            decimal:',',
            precision:4
        }


	$scope.gridOptions = {

		enableFiltering: true,
		enablePaginationControls: true,
		enableGridMenu: true,
		paginationPageSize: 10,
		paginationPageSizes: [10, 20, 30],
		columnDefs: [{
			name: 'codigo',
			field: 'codigo',
			displayName: 'Codigo',
			width:"10%"
		}, {
			name: 'descricao',
			field: 'descricao',
			displayName: 'Descricao'
		}, {
			name: 'embalaje',
			field: 'embalaje',
			displayName: 'Embalaje'
		}, {
			name: 'cantidad',
			field: 'cantidad',
			displayName: 'Cantidad'
		}, {
			name: 'unitario',
			field: 'unitario',
			displayName: 'Valor Unit.'
		}, {
			name: 'total',
			field: 'total',
			displayName: 'Valor Total'
		}
		
		
		]
	};


	$scope.gridOptions.data = [ 
		{codigo:1,descricao:"SAMGSUNG GALAXY 6",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000},
		{codigo:2,descricao:"IPHONE 6",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000},
		{codigo:3,descricao:"LG 6",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000},
		{codigo:4,descricao:"SONY 5",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000}
	];
	
	
	$scope.mercaderias = [ 
		{codigo:1,descricao:"SAMGSUNG GALAXY 6",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000},
		{codigo:2,descricao:"IPHONE 6",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000},
		{codigo:3,descricao:"LG 6",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000},
		{codigo:4,descricao:"SONY 5",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000},
		{codigo:5,descricao:"LG 5",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000},
		{codigo:6,descricao:"SONY 6",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000},
		{codigo:7,descricao:"ARTOZ - ZAFRA 2016",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000},
		{codigo:8,descricao:"SOJA - ZAFRA 2016",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000},
		{codigo:9,descricao:"MILHO - ZAFRA 2016",embalaje:"UND",cantidad:100.00,unitario:1000,total:100000}
	];
	
	
	$scope.embalajes= [
	{id:1,descricao:"UND"},
	{id:2,descricao:"PAQUETE"},
	{id:3,descricao:"CAJA"}	
	];
	
	
});


angular.module('app').directive('infobox', function () {

	return {
		template:
		'<div class="info-box bg-{{cor}}">' +
		'  <span class="info-box-icon"><i class="fa {{icon}}"></i></span>' +
		'  <div class="info-box-content">' +
		'    <span class="info-box-text">{{titulo}}</span>' +
		'    <span class="info-box-number">{{valor}}</span>' +
		'    <!-- The progress section is optional -->' +
		'    <div class="progress">' +
		'      <div class="progress-bar" style="width: {{progresso}}%"></div>' +
		'    </div>' +
		'    <span class="progress-description">' +
		'      {{descricao}}' +
		'    </span>' +
		'  </div>' +
		'</div>',

		replace: true,
		restrict: "A",
		scope: {
			titulo: "@",
			valor: "@",
			progresso: "@",
			descricao: "@",
			cor: "@",
			icon: "@"

		}

	}

});



angular.module('app').directive('box', function () {
	//<element ng-bind-html="expression"></element>
	//<p ng-bind-html-unsafe="data.markupData"></p>
	return {

		template: '<div class="box box-{{cor}}">' +
		'<div class="box-header with-border">' +
		'<h3 class="box-title">{{titulo}}</h3>' +
		'</div>' +
		'<div class="box-body">' +
		'<div ng-transclude=""></div>' +
		'</div>' +
		'</div>',

		replace: true,
		restrict: "A",
		transclude: true,
		scope: {
			titulo: "@",
			cor: "@"
		}

	}
});



angular.module('app').directive('boxs', function () {
	//<element ng-bind-html="expression"></element>
	//<p ng-bind-html-unsafe="data.markupData"></p>
	return {

		template: '<div class="box box-solid box-{{cor}}">' +
		'<div class="box-header">' +
		'<h3 class="box-title">{{titulo}}</h3>' +
		'</div>' +
		'<div class="box-body">' +
		'<div ng-transclude=""></div>' +
		'</div>',

		replace: true,
		restrict: "A",
		transclude: true,
		scope: {
			titulo: "@",
			cor: "@"
		}

	}
});



angular.module('app').directive('boxx', function () {
	//<element ng-bind-html="expression"></element>
	//<p ng-bind-html-unsafe="data.markupData"></p>
	return {

		template: '<div class="box box-{{cor}}">' +
		'<div class="box-header with-border">' +
		'<h3 class="box-title">{{titulo}}</h3>' +
		'<div class="box-tools pull-right">' +
      		'<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>' +
		'</div>' +
		'</div>' +
		'<div class="box-body">' +
		'<div ng-transclude=""></div>' +
		'</div>' +
		'</div>',

		replace: true,
		restrict: "A",
		transclude: true,
		scope: {
			titulo: "@",
			cor: "@"
		}

	}
});




angular.module('app').directive('boxr', function () {
	//<element ng-bind-html="expression"></element>
	//<p ng-bind-html-unsafe="data.markupData"></p>
	return {

		template: '<div class="box box-{{cor}}">' +
		'<div class="box-header with-border">' +
		'<h3 class="box-title">{{titulo}}</h3>' +
		'<div class="box-tools pull-right">' +
      		'<button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>' +
		'</div>' +
		'</div>' +
		'<div class="box-body">' +
		'<div ng-transclude=""></div>' +
		'</div>' +
		'</div>',

		replace: true,
		restrict: "A",
		transclude: true,
		scope: {
			titulo: "@",
			cor: "@"
		}

	}
});




angular.module('app').directive('boxi', function () {
	//<element ng-bind-html="expression"></element>
	//<p ng-bind-html-unsafe="data.markupData"></p>
	return {

		template: '<div class="box box-{{cor}}">' +
		'<div class="box-header with-border">' +
		'<h3 class="box-title">{{titulo}}</h3>' +
		'<div class="box-tools pull-right">' +
		'<div class="has-feedback">' +
		' <input type="text" class="form-control input-sm" placeholder="Search...">' +
		' <span class="glyphicon glyphicon-search form-control-feedback"></span>' +
      		'</div>' +
		'</div>' +
		'</div>' +
		'<div class="box-body">' +
		'<div ng-transclude=""></div>' +
		'</div>' +
		'</div>',

		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			cor: "@"
		}

	}
});




angular.module('app').directive('dxinput', function () {
	// data-inputmask="&quot;mask&quot;: &quot;{{mask}}&quot;"
	return {

		template: 
		'<div class="form-group">' +
		'<label for="{{id}}" class="col-md-2 control-label">{{titulo}}</label>' +
		'<div class="col-md-10">' +
		'  <input type="{{tipo}}" class="form-control col-sm-10" id="{{id}}" placeholder="{{dica}}" ng-model="modelo" >' +
		'</div>' +
		'</div>',

		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			id:"@",
			titulo: "@",
			tipo:"@",
			dica:"@",
			modelo:"="
		}

	}
});

angular.module('app').directive('dxinputv', function () {

	return {

		template: 
 				'<div class="form-group">'+
                '	<label for="{{id}}">{{titulo}}</label>'+
                '	<input type="{{tipo}}" class="form-control" id="{{id}}" placeholder="{{dica}}" ng-model="modelo">'+
                '</div>',

		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			id:"@",
			titulo: "@",
			tipo:"@",
			dica:"@",
			modelo:"="
		}

	}
});
 
 
angular.module('app').directive('dxselectv', function () {

	return {

		template: 
				'<div class="form-group">'+   
				'<label>{{titulo}}</label>'+
				'<div class="select2 select2-container select2-container--default">'+ 
				'<ol class="nya-bs-select"'+ 
				'data-size="10" ng-model="modelo" data-live-search="true"'+ 
				'actions-box="true" style="width: 100%;">'+
				'<li nya-bs-option="op in opcoes"><a>{{ op.descricao }}</a></li>'+
				'</ol>'+
				'</div>'+
				'</div>',
 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			opcoes:"=",
			modelo:"=",
			orientacao:"@"
		}

	}
});
 


angular.module('app').directive('dxselect', function () {

	return {

		template: 
				'<div class="form-group">'+   
				'<label class="col-md-2 col-sm-2 control-label">{{titulo}}</label>'+
				'<div class="col-md-10 col-sm-10 form-control select2 select2-container select2-container--default">'+
				'<ol class="nya-bs-select"'+ 
				'data-size="10" ng-model="modelo" data-live-search="true"'+ 
				'actions-box="true" style="width: 100%;">'+
				'<li nya-bs-option="op in opcoes"><a>{{ op.descricao }}</a></li>'+
				'</ol>'+
				'</div>'+
				'</div>',
 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			opcoes:"=",
			modelo:"=",
			orientacao:"@"
		}

	}
});
 


angular.module('app').directive('dxdate', function () {

	return {

		template: 
				'<div class="form-group">'+
				'<label>{{titulo}}</label>'+
				'<div class="input-group">'+
				'	<span class="input-group-addon"> <span class="glyphicon glyphicon-calendar"></span></span>'+
				'	<input date-range-picker class="form-control date-picker" type="text" ng-model="modelo" options="opcoes" required>'+
				'</div>'+
				'</div>',				
 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			opcoes: "=",
			modelo: "="
			
		}

	}
});
 


angular.module('app').directive('dxmaskmoney', function () {

	return {

		template: 
				'<div class="form-group">'+
				'<label>{{titulo}}</label>'+				 
				'	<input mask-money type="text" class="form-control" ng-model="modelo" mm-options="opcoes" >'+				 
				'</div>',				
 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			titulo: "@",
			opcoes:"=",
			modelo:"="
			
		}

	}
});
 


angular.module('app').directive('dxbutton', function () {

	return {

		template: 
				'<div class="form-group">'+
					'<button type="button" ng-click="modelo" class="form-control btn bg-{{cor}}" style="margin: 24px 0px 24px;"><i class="fa {{icon}}"></i> {{titulo}}</button>'+
				'</div>', 
		replace: true,
		restrict: "EA",
		transclude: true,
		scope: {
			icon:"@",
			cor:"@",
			titulo:"@",
			modelo:"="
	
		}

	}
});
 

    FastClick.attach(document.body);
}();



