'use strict';

app.module.controller('TabelaModalController',[
  '$scope','$uibModalInstance','autorId','LivroService',
function ($scope, $uibModalInstance,autorId,LivroService) {

	  $scope.tabela={};
      $scope.tabelasSelecionadas=[{id:1,nome:'TAB_ENTIDADE'}];
      $scope.tabelas=[
        {name: 'TAB_ENTIDADE', title: 'c1: apple'},
        {name: 'TAB_FATURA', title: 'c2: orange'},
        {name: 'TAB_FATURA_ADICIONAL', title: 'c3: berry'} ,
        {name: 'TAB_FATURA_ITEM', title: 'c3: berry'}  ,
        {name: 'TAB_FATURA_FRETE', title: 'c3: berry'}
      ];

      
  console.log(autorId);
  LivroService.getAutorLivro(autorId)
  .success( function(data){
    $scope.autor=data;
    console.log($scope.autor);
  });


  $scope.ok = function () {
    $uibModalInstance.close($scope.tabela);
  };

  $scope.cancel = function () {
    $uibModalInstance.dismiss('cancel');
  };

}]);
