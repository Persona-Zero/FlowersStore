<template>
  <div>
    <!--   操作面板   -->
    <el-card class="goods-card">
      <div>
        <el-input v-model="param.searchKey" style="width: 240px" @keyup.enter.native="refresh(1)"
                  placeholder="内容"></el-input>
        <el-select v-model="param.searchType" placeholder="分类">
          <el-option
            v-for="type in types"
            :label="type.species_name"
            :value="type.species_name"
          >
          </el-option>
        </el-select>
        <el-button type="primary" icon="el-icon-search" @click="refresh(1)">搜索</el-button>
      </div>
    </el-card>
    <el-card class="main-card">
      <el-row>
        <el-col :span="8" v-for="(o, index) in list" :key="o" :offset="0.1">
          <el-card style="padding:0px;margin:2px">
            <img :src="list[index].img_guid">
            <div style="padding: 14px;">
              <div>
                <el-tag>{{list[index].name}}</el-tag>
                ￥{{list[index].price}}
              </div>
              <div>{{list[index].detail}}</div>
              <div class="bottom clearfix">
                <el-button class="button button-add-cart" icon="el-icon-shopping-cart-1" type="success"
                           @click="addCart(list[index])"></el-button>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <!--   分页  -->
      <div>
        <el-pagination
          background
          layout="prev, pager, next"
          :total="pagination.total"
          :page-size="pagination.pageSize"
          :current-page="pagination.currentPage"
          @current-change="pageChange">
        </el-pagination>
      </div>
    </el-card>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        types: [],
        param: {
          page: 1,
          searchKey: '',
          searchType: '',
        },
        addParam: {
          fid: 1,
          flower: '',
          account: window.sessionStorage.getItem("token"),
        },
        list: [{
          detail: "vvv",
          id: 1,
          img_guid: "static/imgs/meihua.jpg",
          name: "aaa",
          price: 23,
          species_name: "春日",
          state: 1
        }],
        pagination: {
          total: 1,
          pageSize: 9,
          currentPage: 1,
        },
      }
    },
    methods: {

      pageChange(page) {
        this.refresh(page);
      },
      getTypes() {
        //window.sessionStorage.getItem('token')
        this.$http.get("/species/findAll").then(result => {
          let R = result.data;
          this.types = R.data;
        })
      },
      addCart(flower) {
        this.addParam.fid = flower.id;
        this.addParam.flower = flower.name;
        console.log(this.addParam)
        this.$http.post("/cart/create", this.addParam).then(result => {
          let R = result.data; // R
          if (R.code === 2000) {
            this.$message.success(R.msg);
          } else {
            this.$message.error(R.msg);
          }
        });
      },
      refresh(page) {
        if (page === undefined) {
          page = 1;
        }
        //window.sessionStorage.getItem('token')
        this.$http.get("/flower/find?page=" + page + "&searchKey=" + this.param.searchKey
          + "&searchType=" + this.param.searchType
        ).then(result => {
          let R = result.data;
          this.list = R.data.items;
          console.log(this.list);
          this.pagination.total = R.data.len;
          this.pagination.currentPage = page;
        })
      },
    },
    created() {
      this.getTypes();
      this.refresh(1);
    }
  }
</script>

<style scoped>
  .search-input {
    width: 300px;
  }


  .updateForm {
    width: 80%;
  }

  .btn-release {
    float: right;
    margin-top: 10px;
    margin-right: 50px;
  }

  .form-releaseTask {
    height: 300px;
  }

  .input-content-task {
    width: 500px;
  }

  img {
    margin-top: 10px;
    width: 160px;
    height: 160px;
  }

  .main-card {
    background: #B3C0D1;
  }

  .button-add-cart {
    float: right;
    margin: 5px;
  }
</style>
