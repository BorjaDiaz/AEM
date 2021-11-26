//News path Validation
(function (window, $) {
    'use strict';
    /**
     * News Editor Path validation
     *
     * @class NewsPathValidation
     * @classdesc registers a new validator to the foundation-registry service focused on the
     * cq/gui/components/authoring/dialog/pathfield component.
     */
    let NewsPathValidation= function () {
        const CONST = {
            TARGET_GRANITE_UI: '[data-foundation-validation=news-path]',
            ERROR_MESSAGE: 'Absolute path are not allowed!',
        };
        /*REGEX for absolute path*/
        let absolute = /((http|ftp|https):\/\/)?(([\w.-]*)\.([\w]*))/;
        /* for the checking of different pattern example:
        * www.google.com (true)
        * www://google.com (true)
        * http://google.com (true)
        * https://google.com (true)
        * ftp://google.com (true)
        * drive.google.com (true)*/
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
                    //Check first is the path is absolute
                    if(absolute.test(value)){
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
    NewsPathValidation.init();
})(window, Granite.$);