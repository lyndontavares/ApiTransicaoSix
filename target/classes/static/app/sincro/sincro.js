! function($, jQuery, window, document) {
  'use strict';


  app.module.controller('sincroController', SincroController);

  function SincroController($scope, $http, $uibModal, TabelaService,ngNotify) {

    // $http.defaults.headers.common.Authorization = '123';
    // $scope.tabelas = [
    // {id:1,ordemAtualizacao:1,nomeOrigem:'CFGLOCA',nomeDestino:'TAB_LOCALIZACAO',sincronizar:'Sim',data:'22/11/2015',status:'OK'},
    // {id:2,ordemAtualizacao:2,nomeOrigem:'CFGPAIS',nomeDestino:'TAB_PAIS',sincronizar:'Sim',data:'22/11/2015',status:'OK'},
    // {id:3,ordemAtualizacao:3,nomeOrigem:'CFGENTIDADE',nomeDestino:'TAB_ENTIDADE',sincronizar:'Sim',data:'22/11/2015',status:'OK'}
    // ];

    $scope.tabelas = [];

    $scope.loadTabelas = function() {
      TabelaService.getTabelas()
        .success(function(data) {
          $scope.tabelas = data;
        });
    };

    $scope.loadTabelas();


    $scope.sincronizarAll = function(){
        ngNotify.set('Iniciando sincronização', 'info');
        TabelaService.sincronizarAll().
        success( function(){
          ngNotify.set('sincronizado com sucesso', 'success');
          console.log('tabelas sincronizadas');
        })
        .error( function(erro){
          ngNotify.set('Problema: '+erro, 'error');
        });
    };

    $scope.sincronizarSincronizaveis = function(){
        TabelaService.sincronizarSincronizaveis().
        success( function(){
          console.log('tabelas sincronizadas');
        });
    };


    $scope.tabela = {};
    $scope.open = function(size, autorId) {
      var modalInstance = $uibModal.open({
        animation: true,
        templateUrl: 'app/sincro/tabela-modal.html',
        controller: 'TabelaModalController',
        size: size,
        resolve: {
          autorId: function() {
            return autorId;
          }
        }
      });
      modalInstance.result.then(function(tabela) {
    	  	console.info(tabela);
        	
        	$scope.tabela={id:0,ordemAtualizacao:0,tabelaOrigem:'',tabelaDestino:'',sincronizar:1,};
        	$scope.tabela.tabelaOrigem=tabela.tabelaOrigem;
        	$scope.tabela.tabelaDestino=tabela.tabelaDestino;
          $scope.tabela.chavePrimariaDestino=tabela.chavePrimariaDestino;
	        TabelaService.insertTabela($scope.tabela)
	        .success( function( ){
	        	 ngNotify.set('Tabela adicionada com sucesso!', 'success');

               $scope.loadTabelas();
             
	        });
        
      }, function() {
         console.info('Modal dismissed at: ' + new Date());
      });
    };


  }



}();