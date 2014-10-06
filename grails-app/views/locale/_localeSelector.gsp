<%@ page import="com.budgetier.enums.management.LocaleType" %>

<a href="#" class="set-locale-to" param-locale="${LocaleType.ENGLISH.getDescriptive()}">
    <g:img dir="images/flags" file="united_kingdom_glossy_square_icon_256.png" width="30" height="15"/>
</a>
<a href="#" class="set-locale-to" param-locale="${LocaleType.GREEK.getDescriptive()}">
    <g:img dir="images/flags" file="greece_glossy_square_icon_256.png" width="30" height="15"/>
</a>

<g:javascript>

    $(function() {
        $('.set-locale-to').off('click').on('click', function(event) {
            event.preventDefault();
            var url = '<g:createLink controller="locale" action="ajaxSetSessionLocale"/>';
            var locale = $(this).attr('param-locale');
            var parameters = {'locale': locale};
            makeAjaxCall(url, parameters, localeChangeSuccessHandler, localeChangeFailureHandler);
        })
    });

    function localeChangeSuccessHandler(data) {
        console.log('Locale changed successfully.');
    }

    function localeChangeFailureHandler(data) {
        console.log('Locale change failed.');
    }

</g:javascript>