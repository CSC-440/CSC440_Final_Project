<h2>Create ChocoServiceProvided</h2>
   <p id="status"></p>
  <form action="" method="POST" role="form">

    <div class="form-group">
      <label for="chocoServiceProvidedIdNumber">ChocoServiceProvided ID NUMBER</label>
      <input type="text" class="form-control" id="chocoServiceProvidedIdNumber" name="chocoServiceProvidedIdNumber" placeholder="Enter ID number for ChocoServiceProvided.">
    </div>

    <div class="form-group">
      <label for="memberNumberService">Serviced Member ID</label>
      <input type="text" class="form-control" id="memberNumberService" name="memberNumberService" placeholder="Enter ID of serviced member.">
    </div>

    <div class="form-group">
      <label for="providerNumberServicing">Servicing Provider ID</label>
      <input type="text" class="form-control" id="providerNumberServicing" name="providerNumberServicing" placeholder="Enter ID of servicing provider.">
    </div>

    <div class="form-group">
      <label for="dateServiced">Date Serviced</label>
      <input type="text" class="form-control" id="dateServiced" name="dateServiced" placeholder="Enter date service was provided.">
    </div>

    <div class="form-group">
      <label for="dateServicedRecorded">Date Recorded</label>
      <input type="text" class="form-control" id="dateServicedRecorded" name="dateServicedRecorded" placeholder="Enter date the service was recorded.">
    </div>

    <div class="form-group">
      <label for="serviceComment">COMMENT</label>
      <input type="text" class="form-control" id="serviceComment" name="serviceComment" placeholder="Enter comment if any.">
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
            url: "createChocoServiceProvided",
            data: json,
            dataType: "json",
            success : function() {
                $("#status").text("ChocoServiceProvided SuccesFully Added");
                this_.find('input,select').val('');
            },
            error : function(e) {
                console.log(e.responseText);
                $("#status").text(e.responseText);
            }
        });
        $("html, body").animate({ scrollTop: 0 }, "slow");
        return false;
    });
});

</script>
