<h2>Enter Details of Exisiting Service to Update.</h2>
   <p id="status"></p>
  <form action="" method="POST" role="form">
    <div class="form-group">

    <div class="form-group">
      <label for="providableServiceIdNum">ID NUMBER</label>
      <input type="text" class="form-control" id="providableServiceIdNum" name="providableServiceIdNum" placeholder="Enter ID number providable service.">
    </div>

    <div class="form-group">
      <label for="providableServiceDescription">Service Descriptor</label>
      <input type="text" class="form-control" id="providableServiceDescription" name="providableServiceDescription" placeholder="Enter description for providable service.">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>

<!-- Simple JS Function to convert the data into JSON and Pass it as ajax Call --!>
<script>
$(function() {
    $('form').submit(function(e) {
        e.preventDefault();
        var this_ = $(this);
        var array = this_.serializeArray();
        var json = {};
        $.each(array, function() {
            json[this.name] = this.value || '';
        });
        json = JSON.stringify(json);
    
        // Ajax Call
        $.ajax({
            type: "POST",
            url: "updateService",
            data: json,
            dataType: "json",
            success : function() {
                $("#status").text("Service SuccesFully Updated");
                this_.find('input, select').val('');
            },
            error : function(e) {
                $("#status").text(e.responseText);
            }
        });
        $("html, body").animate({ scrollTop: 0 }, "slow");
        return false;
    });
});

</script>
