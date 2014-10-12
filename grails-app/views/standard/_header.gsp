<div class="jumbotron">
    <div class="row">
        <div class="col-sm-10">
            <h1>
                <g:message code="application.name"/>
                <span class="pull-right"><g:render template="/locale/localeSelector"/></span>
            </h1>
            <p>
                <g:message code="application.description"/>
            </p>
        </div>
        <div class="col-sm-2">
            <g:if test="${!session["logged_in_user"]}">
                <div class="row">
                    <div class="col-sm-12">
                        <oauth:connect provider="facebook">
                            <g:img dir="/images/social" file="login-with-facebook.png" width="100%"/>
                        </oauth:connect>
                    </div>
                    <div class="spacer10"></div>
                    <div class="col-sm-12">
                        <g:img dir="/images/social" file="login-with-twitter.png" width="100%"/>
                    </div>
                    <div class="spacer10"></div>
                    <div class="col-sm-12">
                        <g:img dir="/images/social" file="login-with-google.png" width="100%"/>
                    </div>
                </div>
            </g:if>
        </div>
    </div>
</div>

<g:javascript>

    $(function(){
        $('#header_nav').data('size','big');
    });

//    $(window).scroll(function(){
//        if($(document).scrollTop() > 130)
//        {
//            $('.jumbotron').hide();
//            $('.navbar').addClass("navbar-fixed-top");
//        }
//        else
//        {
//            $('.navbar').removeClass("navbar-fixed-top");
//            $('.jumbotron').slideDown("slow");
//        }
//    });


</g:javascript>