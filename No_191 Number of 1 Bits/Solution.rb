# @param {Integer} n, a positive integer
# @return {Integer}
def hamming_weight(n)
  count = 0
  while n != 0
    count += 1
    n = (n - 1) & n
  end
  return count
end