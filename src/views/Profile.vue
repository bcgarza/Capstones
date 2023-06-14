<template>
    <div class='profile'>
        <Header />
        <ProfileCarousel />
    </div>
    
</template>

<script>
import Header from '../components/Header.vue';
import ProfileCarousel from '@/components/ProfileCarousel';

export default{
    components: {
     Header,
     ProfileCarousel
    },
};

</script>

<style>

.profile {
  background-color: #1B1B3A;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  max-height: auto;
  width: 100%;
}

</style>