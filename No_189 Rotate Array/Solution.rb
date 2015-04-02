# @param {Integer[]} nums
# @param {Integer} k
# @return {void} Do not return anything, modify nums in-place instead.
def rotate(nums, k)
  if k >= nums.size
    k %= nums.size
  end

  i = 0
  while i < k
    nums.unshift(nums.pop)
    i += 1
  end 
end