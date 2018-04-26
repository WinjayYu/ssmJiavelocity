toastr.options = {
	"closeButton" : true,
	"debug" : false,
	"progressBar" : true,
	"positionClass" : "toast-top-center",
	"onclick" : null,
	"showDuration" : "300",
	"hideDuration" : "1000",
	"timeOut" : "7000",
	"extendedTimeOut" : "1000",
	"showEasing" : "swing",
	"hideEasing" : "linear",
	"showMethod" : "fadeIn",
	"hideMethod" : "fadeOut"
}

/**
 * 显示toast
 */
function showToast(toast) {
	if (toast.showToastr == 'Y') {
		if (toast.toastrType == 'success') {
			toastr.success(toast.toastrTitle, toast.toastrContent);
		} else if (toast.toastrType == 'info') {
			toastr.info(toast.toastrTitle, toast.toastrContent)
		} else if (toast.toastrType == 'warning') {
			toastr.warning(toast.toastrTitle, toast.toastrContent)
		} else if (toast.toastrType == 'error') {
			toastr.error(toast.toastrTitle, toast.toastrContent)
		}
	}
}