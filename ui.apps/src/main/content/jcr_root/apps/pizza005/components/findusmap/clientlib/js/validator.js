//Find us URL Validation
(function (window, $) {
    'use strict';
    /**
     * Find us Editor Path validation
     *
     * @class FindUsUrlValidation
     * @classdesc registers a new validator to the foundation-registry service focused on the
     * cq/gui/components/authoring/dialog/pathfield component.
     */
    let FindUsUrlValidation= function () {
        const CONST = {
            TARGET_GRANITE_UI: '[data-foundation-validation=findus-map]',
            ERROR_MESSAGE: 'Invalid URL, you should use google maps url',
        };
        /*REGEX for google maps url*/
        let regex = /@(-?\d+\.\d+),(-?\d+\.\d+),(\d+\.?\d?)+z/;
        /**
         * Initializes the RichTextMaxLengthValidation
         */
        function init() {
            // register the validator which includes the validate algorithm
            $(window).adaptTo('foundation-registry').register('foundation.validation.validator', {
                selector: CONST.TARGET_GRANITE_UI,
                validate: function(el) {
                    let element = $(el);
                    let value = element.val();
                    //Check URL
                    if(!regex.test(value)){
                        return Granite.I18n.get(CONST.ERROR_MESSAGE);
                    }
                    return null;
                }
            });
            // execute Jquery Validation onKeyUp
            $(document).on('keyup', CONST.TARGET_GRANITE_UI, function (e) {
                executeJqueryValidation($(this));
            });
        }
        /**
         * Execute foundation.validation.validator's validate algorithm.
         */
        function executeJqueryValidation(el) {
            let validationApi = el.adaptTo('foundation-validation');
            if (validationApi) {
                validationApi.checkValidity();
                validationApi.updateUI();
            }
        }
        return {
            init: init
        }
    }();
    FindUsUrlValidation.init();
})(window, Granite.$);