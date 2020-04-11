<template>
  <div class="container">
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <h2>Sign Up</h2>
      </div>
    </div>
    <div style="margin-top:30px"></div>
    <div class="row">
      <div class="col-sm-4"></div>
      <div class="col-sm-4">
        <form action="/action_page.php">
          <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="enter name" />
          </div>
          <div class="form-group">
            <label for="usr">Email</label>
            <input
              type="email"
              class="form-control"
              id="email"
              name="email"
              placeholder="enter email"
            />
          </div>
          <div class="form-group">
            <label for="pwd">Password</label>
            <input
              type="password"
              class="form-control"
              id="pwd"
              name="password"
              placeholder="enter password"
            />
          </div>
          <div class="form-group">
            <label for="pwd">Confirm Password</label>
            <input
              type="password"
              class="form-control"
              id="confirm-password"
              name="confirm-password"
              placeholder="confirm password"
            />
          </div>
          <button type="submit" class="btn btn-primary">Submit</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>