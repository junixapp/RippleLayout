# RippleLayout
A simple wave ripple effect！

# Screenshot
![](http://i.imgur.com/Fb4X3So.gif)

# Depedency [![](https://jitpack.io/v/li-xiaojun/RippleLayout.svg)](https://jitpack.io/#li-xiaojun/RippleLayout)

1. Add it in your root build.gradle at the end of repositories:

		allprojects {
			repositories {
				...
				maven { url "https://jitpack.io" }
			}
		}

2. Add the dependency:

		dependencies {
		        compile 'com.github.li-xiaojun:RippleLayout:1.0.1'
		}

# Usage
- 主要方法：

		rippleLayout.setRippleColor(Color.RED);
        rippleLayout.setRippleInternal(5000);
        rippleLayout.setRippleCenter(100,200);
        rippleLayout.setEndRadius(300);
	    rippleLayout.startRipple();