jQuery(document).ready(function() {
    var input = document.getElementById("icon");
    if (typeof(FileReader) === 'undefined') {
        layer.msg("Your device is not supported FileReader...",{
            icon:5,
            title:"ITJ Tooltip"
        });
        input.setAttribute('disabled', 'disabled');
    } else {
        input.addEventListener('change', readFile, false);
    }
});
function readFile() {
    var result = document.getElementById("show-icon");
    var file = this.files[0];
    if (!/image\/\w+/.test(file.type)) {
        alert("image only please.");
        layer.msg("The image is only! Please.",{
            icon:5,
            title:"ITJ Tooltip"
        });
        return false;
    }
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function() {
        result.src=this.result;
    }
}