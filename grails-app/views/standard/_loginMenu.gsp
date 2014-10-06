

<div class="container-fluid container-login container-full-width">
    <div class="row login-button-container text-center">
        <div class="col-sm-4 login-entry login-button">
            <div class="facebook-login">
                <oauth:connect provider="facebook" id="facebook-connect-link">
                    <g:img dir="images/social" file="facebook-logo.png" width="75" height="75" class="connect-with-entry" style="position: relative; top: 32px"/>
                </oauth:connect>
            </div>
        </div>
        <div class="col-sm-4 login-entry login-button">
            <div class="twitter-login">
                <oauth:connect provider="twitter">
                    <g:img dir="images/social" file="twitter-logo.png" width="75" height="75" class="connect-with-entry" style="position: relative; top: 32px"/>
                </oauth:connect>
            </div>
        </div>
        <div class="col-sm-4 login-entry login-button">
            <div class="google-login">
                <oauth:connect provider="twitter">
                    <g:img dir="images/social" file="google-g-logo.png" width="75" height="75" class="connect-with-entry" style="position: relative; top: 32px"/>
                </oauth:connect>
            </div>
        </div>
    </div>
</div>