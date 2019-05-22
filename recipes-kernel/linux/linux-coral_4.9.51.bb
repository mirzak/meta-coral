# Copyright (C) 2019 Mirza Krak

SUMMARY = "Linux Kernel provided and supported by Google for Coral Dev Board"

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

SRC_URI = "\
    git://coral.googlesource.com/linux-imx;protocol=https;branch=${SRCBRANCH} \
    file://defconfig \
"

SRCBRANCH = "release-chef"
LOCALVERSION = "-imx"
SRCREV = "a523a59977a69452ece89b01d44a0f3cbf886c17"

KCONFIG_MODE="--alldefconfig"

COMPATIBLE_MACHINE = "coral-dev"
