!function ($, jQuery, window, document) {
    'use strict';

    /**
     * @constructor
     * @public
     *
     * @param $element
     */
    function BodyElementController($element) {
        this.closeSidebar = function () {
                $element.addClass('sidebar-collapse');
        };
    }

    angular.module('app').directive('bodyElement', function () {
        return {
            restrict: 'A',
            controller: BodyElementController
        };
    });
    
}();
