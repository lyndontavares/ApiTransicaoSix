!function($, jQuery, window, document) {

  'use strict';

  app.module.controller('campoController', CampoController);

  function CampoController($scope, $http, $uibModal, CampoService, ngNotify) {

    $scope.campos = [];

    $scope.loadCampos = function() {
      CampoService.getCampos()
        .success(function(data) {
          $scope.campos = data;
        });
    };

    $scope.loadCampos();


    $scope.sincronizarSincronizaveis = function(tabelaOrigem){
        CampoService.insertListaCampos(tabelaOrigem).
        success( function(data){
          console.log('campos inseridos');
        });
    };

  }

}();