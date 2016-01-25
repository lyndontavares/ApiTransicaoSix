angular.module('app', [
	
	'nya.bootstrap.select',
   	'daterangepicker',
	'maskMoney'	,
	'ui.grid',
	'ui.grid.pagination',
	'ui.grid.cellNav',
	'ui.grid.moveColumns'

]);


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
	{ id:2,descricao:'Soja 2015'}
	]

	
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


	$scope.gridOptions = {

		enableFiltering: true,
		enablePaginationControls: true,
		enableGridMenu: true,
		paginationPageSize: 10,
		paginationPageSizes: [10, 20, 30],
		columnDefs: [{
			name: 'id',
			field: 'id',
			displayName: 'Id',
			width:"10%"
		}, {
			name: 'nome',
			field: 'nome',
			displayName: 'Nome'
		}]
	};


	$scope.gridOptions.data = [ 
		{id:1,nome:"Nome-1"},
		{id:2,nome:"Nome-2"},
		{id:3,nome:"Nome-3"},
		{id:4,nome:"Nome-4"},
		{id:5,nome:"Nome-5"},
		{id:6,nome:"Nome-6"},
		{id:7,nome:"Nome-7"},
		{id:8,nome:"Nome-8"},
		{id:9,nome:"Nome-9"},
		{id:10,nome:"Nome-10"}
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
		restrict: "A",
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
		restrict: "A",
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
		restrict: "A",
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
				'data-size="10" ng-model="modelo"'+ 
				'actions-box="true" style="width: 100%;">'+
				'<li nya-bs-option="op in opcoes"><a>{{ op.descricao }}</a></li>'+
				'</ol>'+
				'</div>'+
				'</div>',
 
		replace: true,
		restrict: "A",
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
				'<div class="col-md-10 col-sm-10 select2 select2-container select2-container--default">'+
				'<ol class="nya-bs-select"'+ 
				'data-size="10" ng-model="modelo"'+ 
				'actions-box="true" style="width: 100%;">'+
				'<li nya-bs-option="op in opcoes"><a>{{ op.descricao }}</a></li>'+
				'</ol>'+
				'</div>'+
				'</div>',
 
		replace: true,
		restrict: "A",
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
			opcoes:"=",
			modelo:"="
			
		}

	}
});
 


angular.module('app').directive('dxmaskmoney', function () {

	return {

		template: 
				'<div class="form-group">'+
				'<label>{{titulo}}</label>'+
				'<div class="input-group">'+
				'	<input mask-money type="text" class="form-control" ng-model="modelo" mm-options="opcoes" >'+
				'</div>'+
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
 


