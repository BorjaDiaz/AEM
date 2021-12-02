//Social links Validation
(function (window, $) {
    'use strict';
    /**
     * Social Editor Path validation
     *
     * @class SocialLinksValidation
     * @classdesc registers a new validator to the foundation-registry service focused on the
     * cq/gui/components/authoring/dialog/pathfield component.
     */
    let SocialLinksValidation= function () {
        const CONST = {
            TARGET_GRANITE_UI: '[data-validation=socialURL]',
            ERROR_MESSAGE: 'Add a valid URL',
        };
        /*REGEX for absolute path*/
        let absolute = /^(?:http(s)?:\/\/)[\w.-]+(?:\.[\w\.-]+)+[\w\-\._~:/?#[\]@!\$&'\(\)\*\+,;=.]+$/;
        /**
         * Initializes the SocialLinksValidationValidation
         */
        function init() {
            // register the validator which includes the validate algorithm
            $(window).adaptTo('foundation-registry').register('foundation.validation.validator', {
                selector: CONST.TARGET_GRANITE_UI,
                validate: function(el) {
                    let element = $(el);
                    let value = element.val();
                    //Check first is the path is valid
                    if(value != ""){
                        if(!absolute.test(value)){
                            return Granite.I18n.get(CONST.ERROR_MESSAGE);
                        }
                    }  
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
    SocialLinksValidation.init();
})(window, Granite.$);