app.module.controller('infoController', ['$http', '$scope', 'uiGridConstants', function($http, $scope, uiGridConstants) {

	$scope.gridOptions = {

		enableFiltering: true,
		enablePaginationControls: true,
		enableGridMenu: true,
		paginationPageSize: 10,
		paginationPageSizes: [10, 20, 30],
		columnDefs: [{
			name: 'tabela',
			field: 'tabela',
			displayName: 'Tabela'
		}, {
			name: 'comentarioTabela',
			field: 'comentarioTabela',
			displayName: 'comentarioTabela'
		}, {
			name: 'coluna',
			field: 'coluna',
			displayName: 'coluna'
		}, {
			name: 'tipo',
			field: 'tipo',
			displayName: 'tipo'
		}, {
			name: 'tamanho',
			field: 'tamanho',
			displayName: 'tamanho'
		}, {
			name: 'precisao',
			field: 'precisao',
			displayName: 'precisao'
		}, {
			name: 'comentarioCampo',
			field: 'comentarioCampo',
			displayName: 'comentarioCampo'
		}, ]
	};



	$http.get('http://172.27.10.246:5000/api/info/old')
		.success(function(data) {
			$scope.gridOptions.data = data;
		});


}]);

//angular.element(document.getElementsByClassName('grid')[0]).css('height', newHeight + 'px');