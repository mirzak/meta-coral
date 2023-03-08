# Copyright (C) 2020 Mirza Krak
require recipes-kernel/linux/linux-imx.inc
SUMMARY = "Linux Kernel provided and supported by Google for Coral Dev Board"

DEPENDS += "lzop-native bc-native"

LINUX_VERSION = "4.14.98"

SRCREV = "c13f50afd3920f718f9becc9f47c31fccba00bf7"
SRC_URI = "\
    git://coral.googlesource.com/linux-imx;protocol=https;branch=master \
    file://0001-scripts-dtc-Remove-redundant-YYLOC-global-declaratio.patch \
    file://0002-include-linux-module.h-copy-__init-__exit-attrs-to-i.patch \
    file://0003-Compiler-Attributes-add-support-for-__copy-gcc-9.patch \
    file://0004-Add-an-alias-for-imx8mq-phanbell.dts.patch \
    file://defconfig \
    file://mendel.cfg \
    file://extra.cfg \
"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

COMPATIBLE_MACHINE = "coral-dev"
