# Copyright (C) 2023 Khem Raj
require recipes-kernel/linux/linux-imx.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

SUMMARY = "Linux Kernel provided and supported by Google for Coral Dev Board"

DEPENDS += "lzop-native bc-native"

LINUX_VERSION = "5.4.237"

FILESPATH =. "${FILE_DIRNAME}/${BPN}-5.4:"

SRCREV = "33630781929731d93d24c944689add3da38c8e93"
SRC_URI = "\
    git://github.com/Freescale/linux-fslc;protocol=https;branch=5.4-2.3.x-imx \
    file://extra.cfg \
    file://wifi.cfg \
    file://werror.cfg \
    file://0001-regulator-bd718x7-Add-MODULE_ALIAS.patch \
    file://0002-regulator-bd718x7-Simplify-the-code-by-removing-stru.patch \
    file://0003-mfd-Rohm-PMICs-Use-platform_device_id-to-match-MFD-s.patch \
    file://0004-regulator-bd718x7-Split-driver-to-common-and-bd718x7.patch \
    file://0005-regulator-bd718x7-remove-voltage-change-restriction-.patch \
    file://0006-arm64-dts-freescale-add-initial-support-for-Google-i.patch \
    file://0007-arm64-dts-imx8mq-phanbell-Add-support-for-ethernet.patch \
    file://0008-arm64-dts-imx8mq-phanbell-Add-gpio-fan-thermal-suppo.patch \
    file://0009-arm64-dts-imx8mq-phanbell-Fix-Ethernet-PHY-post-rese.patch \
    file://0010-arm64-dts-imx8mq-phanbell-Replace-deprecated-phy-res.patch \
    file://0011-arm64-dts-imx8mq-phanbell-Align-pin-configuration-gr.patch \
    file://0012-arm64-dts-imx8mq-phanbell-Disable-busfreq-to-avoid-s.patch \
    file://0013-MLK-15307-2-clk-imx8mq-set-the-parent-clocks-of-PCIE.patch \
    file://0014-arm64-dts-imx8mq-Set-ext_osc-to-1-as-default.patch \
    file://0015-PCI-imx-Use-the-external-clock-as-REF_CLK-when-neede.patch \
    file://0016-PCI-imx-Provide-a-clock-to-the-device-for-i.MX8MQ.patch \
    file://0017-arm64-dts-imx8mq-phanbell-Enable-PCIe.patch \
    file://0018-spi-spi-imx-Revive-cs-gpios-property-for-DT.patch \
    file://0019-arm64-dts-imx8mq-phanbell-Enable-ECSPI1.patch \
    file://0020-arm64-dts-imx8mq-phanbell-Add-gpio-pinmux-for-40-pin.patch \
    file://0021-arm64-dts-imx8mq-phanbell-Enable-I2C-2-I2C-3.patch \
"
KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

OBJCOPY:toolchain-clang = "${HOST_PREFIX}objcopy"

COMPATIBLE_MACHINE = "coral-dev"
