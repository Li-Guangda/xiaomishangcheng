<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">用户信息</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">

            <h4>${sessionScope.userName}</h4>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">手机号</span>
                <input type="text" class="form-control" disabled placeholder="${sessionScope.userMobile}" aria-label="Username" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
                <span class="input-group-text" id="basic-addon1">收货地址</span>
                <input id="user-address-1" type="text" class="form-control" placeholder="" aria-label="Username" aria-describedby="basic-addon1">
            </div>

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" onclick="updateUserInfo(${sessionScope.userId})">保存</button>
      </div>
    </div>
  </div>
</div>

