<g:if test="${flash.error}">
    <div class="row">
        <div class="col-sm-12">
            <div class="alert alert-danger">
                <h5>
                    ${flash.error}
                </h5>
            </div>
        </div>
    </div>
</g:if>

<g:if test="${flash.success}">
    <div class="row">
        <div class="col-sm-12">
            <div class=" alert alert-success">
                <h5>
                    ${flash.success}
                </h5>
            </div>
        </div>
    </div>
</g:if>

<g:if test="${flash.warning}">
    <div class="row">
        <div class="col-sm-12 alert alert-warning">
            <h5>
                ${flash.warning}
            </h5>
        </div>
    </div>
</g:if>