# 유클리드 호제법

# GCD (최대공약수)
3, 7, 9의 최대 공약수는 63

```python
def gcd(x, y, z):
    count = 0
    while count%x != 0 or count%y != 0 or count%z != 0:
        count += 1
    return count
x, y, z = map(int, input().split())
gcd(x, y, z)
```
# LCM (최소공배수)
63 의 최소 공배수는 3
```python
def lcm(x,y,z):
    return (x*y*z)//gcd(x,y,z)


x, y, z = map(int, input().split())
lcm(x, y, z)
```