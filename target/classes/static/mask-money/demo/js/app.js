angular.module('angularMaskMoneyDemo', ['maskMoney']).run(['$rootScope',
    function($scope) {

        console.log('app is running')

        $scope.options = {
            prefix: 'R$_',
            thousands:'.', 
            decimal:',',
            precision:4

            //<input type="text" id="demo4" data-thousands="." data-decimal="," data-prefix="R$ " />
        }


        $scope.options2 = {
            prefix: 'erik'
        }

        $scope.anotherModel = 'someString'

    }
])