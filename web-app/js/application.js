if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}

/**
 * Make ajax call to url by attaching params. In successful response call the
 * success callback given, otherwise call the failure callback method provided.
 *
 * @param url, the server path were the call is made.
 * @param params, the parameters to accompany the server call.
 * @param success, called when a successful response has been retrieved.
 * @param failure, called when a failure occurs either as a server response or communication failed.
 */
function makeAjaxCall(url, params, success, failure) {

    $.post(url, params, function(data, textStatus, jqXHR) {
        console.log('Post succeeded...');

        if (data.success == false) {
            failure(data);
        } else {
            success(data);
        }
    }).fail(function(error, data, jqXHR) {
        failure(data);
    })
}